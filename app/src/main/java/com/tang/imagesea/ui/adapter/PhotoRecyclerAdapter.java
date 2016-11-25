package com.tang.imagesea.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.tang.imagesea.R;
import com.tang.imagesea.model.PhotoBean;
import com.tang.imagesea.utils.ImageUtils;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.PhotoViewHolder> {
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

    public void addDatas(List<PhotoBean> mDatas) {
        this.mDatas.addAll(mDatas);
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PhotoViewHolder holder = new PhotoViewHolder(LayoutInflater.from(context).inflate(R.layout.photo_item_view, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.contentLayout.getLayoutParams();

        PhotoBean photo = mDatas.get(position);
        lp.height = getImageLayoutHeight(photoItemWidth,photo);
        holder.contentLayout.setLayoutParams(lp);

        final int backgroundColor = Color.parseColor(photo.getColor());
        holder.contentLayout.setBackgroundColor(backgroundColor);
        holder.imageView.setImageDrawable(new ColorDrawable(backgroundColor));
        ImageUtils.displayImageView(photo.getUrls().getRegular(),holder.imageView, ImageUtils.defaultPhotoOption);

    }

    private int getImageLayoutHeight(int layOutWidth, PhotoBean photo){
        float ratio = (float)photo.getHeight()/(float)photo.getWidth();
        return (int)(layOutWidth*ratio);
    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }


    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        FrameLayout contentLayout;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            contentLayout = (FrameLayout) itemView.findViewById(R.id.id_photo_item_content);
            imageView = (ImageView) itemView.findViewById(R.id.photo_item_img);
        }
    }

}
