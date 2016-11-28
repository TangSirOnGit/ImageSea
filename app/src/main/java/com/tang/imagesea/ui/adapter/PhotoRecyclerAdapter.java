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

        updateHolderImageContent(holder.imageView, photo);

    }

    private void updateHolderImageContent(SimpleDraweeView imageView, PhotoBean photo) {
        Uri uri = Uri.parse(photo.getUrls().getRegular());

        final int backgroundColor = Color.parseColor(photo.getColor());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(7f);
        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(imageView.getContext().getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(300)
                .setPlaceholderImage(new ColorDrawable(backgroundColor))
                .setRoundingParams(roundingParams)
                .build();
        imageView.setHierarchy(hierarchy);

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(imageView.getController())
                .build();
        imageView.setController(controller);

        imageView.setImageURI(uri);
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
        SimpleDraweeView imageView;
        FrameLayout contentLayout;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            contentLayout = (FrameLayout) itemView.findViewById(R.id.id_photo_item_content);
            imageView = (SimpleDraweeView) itemView.findViewById(R.id.photo_item_img);
        }
    }

}
