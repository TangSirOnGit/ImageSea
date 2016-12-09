package com.tang.imagesea.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.tang.imagesea.R;
import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.ui.listener.OnPhotoListItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.PhotoViewHolder>
        implements View.OnClickListener{
    private Context context;

    private List<PhotoBean> mDatas;

    public void setPhotoItemWidth(int photoItemWidth) {
        this.photoItemWidth = photoItemWidth;
    }

    private int photoItemWidth = 0;
    //private List<Integer> mHeights;

    public PhotoRecyclerAdapter(Context context) {
        super();
        this.context = context;
    }

    public void setDatas(List<PhotoBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    public List<PhotoBean> getmDatas() {
        return mDatas;
    }

    public void addDatas(List<PhotoBean> mDatas) {
        this.mDatas.addAll(mDatas);
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photo_item_view, parent, false);
        view.setOnClickListener(this);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.contentLayout.getLayoutParams();

        PhotoBean photo = mDatas.get(position);
        lp.height = getImageLayoutHeight(photoItemWidth,photo);
        holder.contentLayout.setLayoutParams(lp);
        holder.itemView.setTag(position);

        updateHolderImageContent(holder, photo);

    }

    private void updateHolderImageContent(PhotoViewHolder holder, PhotoBean photo) {
        Uri uri = Uri.parse(photo.getUrls().getRegular());

        final int backgroundColor = Color.parseColor(photo.getColor());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(7f);
        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(holder.imageView.getContext().getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setPlaceholderImage(new ColorDrawable(backgroundColor))
                .setRoundingParams(roundingParams)
                .build();
        holder.imageView.setHierarchy(hierarchy);

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(holder.imageView.getController())
                .build();
        holder.imageView.setController(controller);

        holder.imageView.setImageURI(uri);

        //holder.authorImg.setImageURI(Uri.parse(photo.getUser().getProfile_image().getMedium()));
        //holder.authorName.setText(photo.getUser().getName());
    }

    private int getImageLayoutHeight(int layOutWidth, PhotoBean photo){
        float ratio = (float)photo.getHeight()/(float)photo.getWidth();
        return (int)(layOutWidth*ratio);
    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }


    class PhotoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photo_item_img)
        SimpleDraweeView imageView;
        @BindView(R.id.photo_item_author_pic)
        SimpleDraweeView authorImg;
        @BindView(R.id.photo_item_author_name)
        TextView authorName;
        @BindView(R.id.id_photo_item_content)
        FrameLayout contentLayout;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
//            contentLayout = (FrameLayout) itemView.findViewById(R.id.id_photo_item_content);
//            imageView = (SimpleDraweeView) itemView.findViewById(R.id.photo_item_img);            imageView = (SimpleDraweeView) itemView.findViewById(R.id.photo_item_img);
//            authorImg = (SimpleDraweeView) itemView.findViewById(R.id.photo_item_author_pic);
//            authorName = (TextView) itemView.findViewById(R.id.photo_item_author_name);
        }
    }

    public void setOnItemClickListener(OnPhotoListItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    private OnPhotoListItemClickListener mOnItemClickListener = null;

}
