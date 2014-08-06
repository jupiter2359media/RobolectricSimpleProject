package vn.jupiter.simpletestproject;

import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;

/**
 * @author Jupiter (vu.cao.duy@gmail.com) on 8/6/14.
 */
public class SimpleCustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        configImageLoader();
    }

    private void configImageLoader() {
        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
        if (cacheDir == null) {
            cacheDir = Environment.getDownloadCacheDirectory();
        }
        DisplayImageOptions options = getBasicDisplayOptions(false).build();

        int maxWidth = 800;
        int maxHeight = 480;
        int threadPoolSize = 1;

        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .threadPoolSize(threadPoolSize)
                .memoryCacheExtraOptions(maxWidth, maxHeight)
                .memoryCache(new LRULimitedMemoryCache(3 * 1024 * 1024))
                .diskCacheExtraOptions(maxWidth, maxHeight, null)
                .diskCache(new LimitedAgeDiscCache(cacheDir, 3600 * 24 * 7))
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .imageDownloader(new BaseImageDownloader(getApplicationContext()))
                .defaultDisplayImageOptions(options);

        ImageLoaderConfiguration config = builder.build();
        ImageLoader.getInstance().init(config);
    }

    public static DisplayImageOptions.Builder getBasicDisplayOptions(boolean isLowEndDevices) {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .resetViewBeforeLoading(true)
                    .imageScaleType(ImageScaleType.EXACTLY);
        if (isLowEndDevices) {
            builder.bitmapConfig(Bitmap.Config.RGB_565);
        }
        return builder;
    }

}
