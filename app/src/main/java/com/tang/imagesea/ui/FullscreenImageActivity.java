package com.tang.imagesea.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tang.imagesea.R;
import com.tang.imagesea.manager.DataManager;
import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.utils.Constants;
import com.tang.imagesea.utils.LogUtils;
import com.tang.imagesea.utils.ParamUtils;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullscreenImageActivity extends AppCompatActivity {
    @BindView(R.id.id_photo_fullscreen_img)
    SimpleDraweeView fullScreenImage;

    @BindView(R.id.fullscreen_content_controls)
    View mControlsView;

    private String imageType = "";
    private int pageIndex = 1;
    private int photoIndex = 0;
    private List<PhotoBean> photoList = new ArrayList<>();
    private PhotoBean photo;
    DataDisposeHandler dataHandler = null;
    private GestureDetector mGestureDetector;

    private boolean mVisible;

    private static final boolean AUTO_HIDE = true;

    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            fullScreenImage.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };

    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
               // actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the system UI. This is to
     * prevent the jarring behavior of controls going away while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen_image);
        ButterKnife.bind(this);

        mVisible = true;
        dataHandler = new DataDisposeHandler(this);

        initView();
        initGesture();
        hideNavigation();
        initData();
        loadPhotos(pageIndex);

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        //findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    private void initView(){
//        fullScreenImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toggle();
//            }
//        });
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        delayedHide(0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //2.让手势识别器生效
        return mGestureDetector.onTouchEvent(event);
        //return super.onTouchEvent(event);
    }

    private void initGesture(){
        mGestureDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                   float velocityY) {
                // e1: 第一次按下的位置   e2   当手离开屏幕 时的位置  velocityX  沿x 轴的速度  velocityY： 沿Y轴方向的速度
                LogUtils.showLog("onFling");
                //判断竖直方向移动的大小
                if((e1.getRawY() - e2.getRawY())>200
                        ||(e1.getRawX() - e2.getRawX()) >200){
                    LogUtils.showLog("onFling 111");
                    showNextImage();
                    return true;
                }

                if((e2.getRawY() - e1.getRawY())>200
                        ||(e2.getRawX() - e1.getRawX()) >200){  //向左滑动 表示 上一页
                    LogUtils.showLog("onFling 444");
                    showPrevImage();
                    return true;//消费掉当前事件  不让当前事件继续向下传递
                }

                if(Math.abs(velocityX)<150){
                    LogUtils.showLog("onFling 222");
                    //Toast.makeText(getApplicationContext(), "移动的太慢", 0).show();
                    return true;
                }

                LogUtils.showLog("onFling 555");
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }

    private void showNextImage(){
        if (photoIndex<Constants.PHOTOS_PAGE_SIZE-1){
            photoIndex++;
        }

        updateImage(photoIndex);
    }

    private void showPrevImage(){
        if (photoIndex>0){
            photoIndex--;
        }
        updateImage(photoIndex);
    }
    private void initData(){
        Intent inputIntent = getIntent();
        imageType = inputIntent.getStringExtra(ParamUtils.KEY_PHOTO_TYPE);
        pageIndex = inputIntent.getIntExtra(ParamUtils.KEY_PHOTO_PAGE_INDEX,1);
        photoIndex = inputIntent.getIntExtra(ParamUtils.KEY_PHOTO_ITEM_INDEX,0);
        //photo = getIntent().getParcelableExtra(ParamUtils.KEY_PHOTO_BEAN);
    }

    private void loadPhotos(final int pageIndex){
        new Thread(new Runnable() {
            @Override
            public void run() {
                getPhotos(pageIndex);
            }
        }).start();
    }

    private void getPhotos(int pageIndex){
        List<PhotoBean>  photos = DataManager.getPhotos(pageIndex, Constants.PHOTOS_PAGE_SIZE,imageType);
        if (photos != null) {
            Message msg = dataHandler.obtainMessage(Constants.MSG_GET_PHOTOS_SUCCESS);
            msg.arg1 = pageIndex;
            msg.obj = photos;
            dataHandler.sendMessage(msg);
        }
    }

    private void updateImage(int index){
        LogUtils.showLog("updateImage, index="+index);
        photo = photoList.get(index);
        fullScreenImage.setImageURI(photo.getUrls().getRegular());
    }

    private void updatePhotosData(int pageIndex, List<PhotoBean> photos){
        this.photoList = photos;
        updateImage(photoIndex);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    private void hideNavigation() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, 0);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        fullScreenImage.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        //mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    private int getScreenSize(int type){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();

        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics",DisplayMetrics.class);
            method.invoke(display, displayMetrics);
            LogUtils.showLog("getScreenSize,real h="+displayMetrics.heightPixels);
        }catch(Exception e){
            e.printStackTrace();
        }

        if (type==0) {
            return displayMetrics.widthPixels;
        }else{
            return displayMetrics.heightPixels;
        }
    }

    private static class DataDisposeHandler extends Handler {
        private final WeakReference<FullscreenImageActivity> mTargetActivity
                ;

        DataDisposeHandler(FullscreenImageActivity activity) {
            mTargetActivity
                    = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg == null || mTargetActivity
                    == null) {
                return;
            }

            FullscreenImageActivity activity = mTargetActivity
                    .get();
            if (activity == null) {
                return;
            }

            switch (msg.what) {
                case Constants.MSG_GET_PHOTOS_SUCCESS:
                    activity.updatePhotosData(msg.arg1, (List<PhotoBean>)msg.obj);
                    break;

                default:
                    break;
            }
        }
    }
}
