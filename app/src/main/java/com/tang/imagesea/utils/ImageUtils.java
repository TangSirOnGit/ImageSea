package com.tang.imagesea.utils;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by tangsir on 2016/11/25.
 */

public class ImageUtils {
    public static void displayImageView(String url, ImageView imageView) {
        displayImageView(url, imageView, null);
    }

    public static void displayImageView(String url, ImageView imageView,
                                        DisplayImageOptions displayImageOptions) {


        ImageLoader.getInstance().displayImage(url, imageView, displayImageOptions);
    }



    public static void displayImageViewWithAnimation(String url,
                                                     ImageView imageView, DisplayImageOptions displayImageOptions,
                                                     ImageLoadingListener imageLoadingListener) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        if (null == imageView) {
            imageLoader.loadImage(url, null);
        } else {
            imageLoader.displayImage(url, imageView,
                    displayImageOptions, imageLoadingListener);

        }
    }

    public static void initImageLoader(Context context) {

        LogUtils.debug("initImageLoader");
        DiskCache cache = null;


        MemoryCache memoryCache = new LRULimitedMemoryCache(15 * 1024 * 1024);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                // 内存缓存的设置选项 (最大图片宽度,最大图片高度) 默认当前屏幕分辨率
                .memoryCacheExtraOptions(480, 300)

                // 设置自定义加载和显示图片的线程池
                .taskExecutor(
                        DefaultConfigurationFactory.createExecutor(5,
                                Thread.NORM_PRIORITY - 1,
                                QueueProcessingType.FIFO))
                // 设置自定义加载和显示内存缓存或者硬盘缓存图片的线程池
                .taskExecutorForCachedImages(
                        DefaultConfigurationFactory.createExecutor(5,
                                Thread.NORM_PRIORITY - 1,
                                QueueProcessingType.FIFO))

                // 设置拒绝缓存在内存中一个图片多个大小 默认为允许,(同一个图片URL)根据不同大小的imageview保存不同大小图片
                .denyCacheImageMultipleSizesInMemory()

                // 设置内存缓存最大大小占当前应用可用内存的百分比 默认为一个当前应用可用内存的1/8
                // .memoryCacheSizePercentage(13) // default 12.5

                .memoryCache(memoryCache)

                // 设置硬盘缓存
                // 默认为StorageUtils.getCacheDirectory(getApplicationContext())
                // 即/mnt/sdcard/android/data/包名/cache/
                .diskCache(cache) // default
                // .diskCache(new
                // UnlimitedDiscCache(StorageUtils.getCacheDirectory(context),null,new
                // CustomFileNameGenerator()))

                // 设置图片下载器
                // 默认为
                // DefaultConfigurationFactory.createImageDownloader(context)
                .imageDownloader(
                        DefaultConfigurationFactory
                                .createImageDownloader(context)) // default
                // 设置图片解码器
                // 默认为DefaultConfigurationFactory.createImageDecoder(false)
                .imageDecoder(
                        DefaultConfigurationFactory.createImageDecoder(false)) // default
                // 设置默认的图片显示选项
                // 默认为DisplayImageOptions.createSimple()
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                // 打印DebugLogs
                .writeDebugLogs().build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
    public static final DisplayImageOptions defaultPhotoOption = new DisplayImageOptions.Builder().resetViewBeforeLoading(false) // default
            .cacheInMemory(true) // default
            .cacheOnDisk(true) // default
            .considerExifParams(false) // default
            .build();
}
