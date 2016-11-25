package com.tang.imagesea.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tang.imagesea.R;
import com.tang.imagesea.manager.DataManager;
import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.ui.adapter.PhotoRecyclerAdapter;
import com.tang.imagesea.ui.listener.PhotoListScrollListener;
import com.tang.imagesea.ui.listener.ScrollEndWorker;
import com.tang.imagesea.utils.LogUtils;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhotosFragment extends Fragment implements ScrollEndWorker {
    private final static int MSG_GET_PHOTOS_SUCCESS = 2001;
    private final static int MSG_GET_PHOTOS_FAIL = 2002;

    private final static int COLUMN_NUM = 2;

    @BindView(R.id.photo_list)
    RecyclerView photoListView;

    PhotoRecyclerAdapter adapter;
    PhotoListScrollListener scrollListener;

    DataDisposeHandler dataHandler;

    //private int currentDataPage = 1;

    private SparseArray pageStatusArray =  new SparseArray();
    private static final int PAGE_STATUS_LOADING = 1;
    private static final int PAGE_STATUS_LOAD_SUCCESS = 2;
    private static final int PAGE_STATUS_LOAD_FAIL = 3;

    public PhotosFragment() {
        // Required empty public constructor
    }


    public static PhotosFragment newInstance() {
        return  new PhotosFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPhotosByPage(1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView(){
        dataHandler = new DataDisposeHandler(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(COLUMN_NUM, StaggeredGridLayoutManager.VERTICAL);
        photoListView.setLayoutManager(layoutManager);
        scrollListener = new PhotoListScrollListener(layoutManager, this);

        adapter =  new PhotoRecyclerAdapter(getActivity().getApplicationContext());
        adapter.setPhotoItemWidth(getItemWidth());
        photoListView.setAdapter(adapter);
        photoListView.setOnScrollListener(scrollListener);
    }

    private void loadPhotosByPage(final int page){
        if (!(pageStatusArray.get(page) == null
                ||(int) pageStatusArray.get(page)==MSG_GET_PHOTOS_FAIL)){
            return;
        }

        pageStatusArray.put(page ,PAGE_STATUS_LOADING);
        new Thread(new Runnable() {
            @Override
            public void run() {
                getPhotos(page);
            }
        }).start();
    }

    private void getPhotos(int page){
        LogUtils.showLog("getPhotos, page="+page);
        List<PhotoBean> photos= DataManager.getPhotos(page ,30,"latest");
        LogUtils.showLog("getPhotos, photos="+photos);
        if (photos != null) {
            Message msg = dataHandler.obtainMessage(MSG_GET_PHOTOS_SUCCESS);
            msg.arg1 = page;
            msg.obj = photos;
            dataHandler.sendMessage(msg);
        }else{
            if(page ==1){
                loadPhotosByPage(page);
            }else{
                Message msg = dataHandler.obtainMessage(MSG_GET_PHOTOS_FAIL);
                msg.arg1 = page;
                dataHandler.sendMessage(msg);
            }
        }
    }

    private void updatePhotoData(int page,List<PhotoBean> photos){
        LogUtils.showLog("updatePhotoData,page="+page);
        if ((int) pageStatusArray.get(page) == PAGE_STATUS_LOAD_SUCCESS){
            return;
        }
        if (page==1){
            adapter.setDatas(photos);
        }else{
            adapter.addDatas(photos);
        }
        pageStatusArray.put(page , PAGE_STATUS_LOAD_SUCCESS);
        scrollListener.setLoadFinished(page, true);
    }

    private void onLoadPhotoFail(int page){
        pageStatusArray.put(page, PAGE_STATUS_LOAD_FAIL);
        scrollListener.setLoadFinished(page, false);
    }

    private int getItemWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels/COLUMN_NUM;
    }

    @Override
    public void loadMore(int currentPage){
        loadPhotosByPage(currentPage);
    }
    private static class DataDisposeHandler extends Handler {
        private final WeakReference<PhotosFragment> mTargetFragment
                ;

        DataDisposeHandler(PhotosFragment fragment) {
            mTargetFragment
                    = new WeakReference<>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg == null || mTargetFragment
                    == null) {
                return;
            }

            PhotosFragment fragment = mTargetFragment
                    .get();
            if (fragment == null) {
                return;
            }

            switch (msg.what) {
                case MSG_GET_PHOTOS_SUCCESS:
                    fragment.updatePhotoData(msg.arg1,(List<PhotoBean>)msg.obj);
                    break;
                case MSG_GET_PHOTOS_FAIL:
                    fragment.onLoadPhotoFail(msg.arg1);
                    break;

                default:
                    break;
            }
        }
    }
}
