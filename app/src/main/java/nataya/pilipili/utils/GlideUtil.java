package nataya.pilipili.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

import nataya.pilipili.R;

/**
 * glide工具类
 *
 * @author PengZhenjin
 * @date 2016/8/2
 */
public class GlideUtil {

    /**
     * 加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param defResourceId
     * @param isGif         是否是gif图片
     */
    public static void loadImage(String url, Context context, ImageView imageView, int defResourceId, boolean isGif) {
        if (isGif) {
            Glide.with(context.getApplicationContext()).load(url).asBitmap().placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext()).load(url).placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
        }
    }

    /**
     * 加载图片
     *
     * @param resourceId
     * @param context
     * @param imageView
     * @param defResourceId
     * @param isGif         是否是gif图片
     */
    public static void loadImage(Integer resourceId, Context context, ImageView imageView, int defResourceId, boolean isGif) {
        if (isGif) {
            Glide.with(context.getApplicationContext())
                 .load(resourceId)
                 .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext()).load(resourceId).placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
        }
    }

    /**
     * 加载图片
     *
     * @param uri
     * @param context
     * @param imageView
     * @param defResourceId
     * @param isGif         是否是gif图片
     */
    public static void loadImage(Uri uri, Context context, ImageView imageView, int defResourceId, boolean isGif) {
        if (isGif) {
            Glide.with(context.getApplicationContext())
                 .load(uri)
                 .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext()).load(uri).placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
        }
    }

    /**
     * 加载图片
     *
     * @param file
     * @param context
     * @param imageView
     * @param defResourceId
     * @param isGif         是否是gif图片
     */
    public static void loadImage(File file, Context context, ImageView imageView, int defResourceId, boolean isGif) {
        if (isGif) {
            Glide.with(context.getApplicationContext())
                 .load(file)
                 .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext()).load(file).placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
        }
    }

    /**
     * 是否禁止磁盘缓存加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param type          缓存的类型
     *                      <li>磁盘缓存全部 DiskCacheStrategy.ALL</li>
     *                      <li>磁盘禁止缓存DiskCacheStrategy.NONE</li>
     * @param defResourceId
     */
    public static void loadImage(String url, Context context, ImageView imageView, DiskCacheStrategy type, int defResourceId) {
        Glide.with(context.getApplicationContext()).load(url).diskCacheStrategy(type).placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
    }

    /**
     * 是否禁止内存缓存加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param skipMemoryCache 禁止内存缓存 true为禁止
     * @param defResourceId
     */
    public static void loadImage(String url, Context context, ImageView imageView, boolean skipMemoryCache, int defResourceId) {
        Glide.with(context.getApplicationContext()).load(url).skipMemoryCache(skipMemoryCache).placeholder(defResourceId).error(R.drawable.default_image_failed).into(imageView);
    }

    /**
     * 是否禁止内存/磁盘缓存加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param type            缓存的类型
     *                        <li>磁盘缓存全部 DiskCacheStrategy.ALL</li>
     *                        <li>磁盘禁止缓存DiskCacheStrategy.NONE</li>
     * @param skipMemoryCache 禁止内存缓存 true为禁止
     * @param defResourceId
     */
    public static void loadImage(String url, Context context, ImageView imageView, DiskCacheStrategy type, boolean skipMemoryCache, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(url)
             .skipMemoryCache(skipMemoryCache)
             .diskCacheStrategy(type)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadCircleImage(String url, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext()).load(url).placeholder(defResourceId).error(defResourceId).bitmapTransform(new GlideCircleTransform(context)).into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param resourceId
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadCircleImage(Integer resourceId, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(resourceId)
             .placeholder(defResourceId)
             .error(defResourceId)
             .bitmapTransform(new GlideCircleTransform(context))
             .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param uri
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadCircleImage(Uri uri, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext()).load(uri).placeholder(defResourceId).error(defResourceId).bitmapTransform(new GlideCircleTransform(context)).into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param file
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadCircleImage(File file, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext()).load(file).placeholder(defResourceId).error(defResourceId).bitmapTransform(new GlideCircleTransform(context)).into(imageView);
    }

    /**
     * 加载圆角图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param roundRadius
     * @param defResourceId
     */
    public static void loadRoundImage(String url, final Context context, final ImageView imageView, int roundRadius, int defResourceId) {
        if (roundRadius < 0) {
            Glide.with(context.getApplicationContext())
                 .load(url)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .bitmapTransform(new GlideRoundTransform(context))
                 .into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext())
                 .load(url)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .bitmapTransform(new GlideRoundTransform(context, roundRadius))
                 .into(imageView);
        }
    }

    /**
     * 加载圆角图片
     *
     * @param uri
     * @param context
     * @param imageView
     * @param roundRadius
     * @param defResourceId
     */
    public static void loadRoundImage(Uri uri, final Context context, final ImageView imageView, int roundRadius, int defResourceId) {
        if (roundRadius < 0) {
            Glide.with(context.getApplicationContext())
                 .load(uri)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .bitmapTransform(new GlideRoundTransform(context))
                 .into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext())
                 .load(uri)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .bitmapTransform(new GlideRoundTransform(context, roundRadius))
                 .into(imageView);
        }
    }

    /**
     * 加载圆角图片
     *
     * @param file
     * @param context
     * @param imageView
     * @param roundRadius
     * @param defResourceId
     */
    public static void loadRoundImage(File file, final Context context, final ImageView imageView, int roundRadius, int defResourceId) {
        if (roundRadius < 0) {
            Glide.with(context.getApplicationContext())
                 .load(file)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .bitmapTransform(new GlideRoundTransform(context))
                 .into(imageView);
        }
        else {
            Glide.with(context.getApplicationContext())
                 .load(file)
                 .placeholder(defResourceId)
                 .error(R.drawable.default_image_failed)
                 .bitmapTransform(new GlideRoundTransform(context, roundRadius))
                 .into(imageView);
        }
    }

    /**
     * 加载模糊图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadBlurImage(String url, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(url)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .bitmapTransform(new GlideBlurTransformation(context))
             .into(imageView);
    }

    /**
     * 加载模糊图片
     *
     * @param uri
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadBlurImage(Uri uri, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(uri)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .bitmapTransform(new GlideBlurTransformation(context))
             .into(imageView);
    }

    /**
     * 加载模糊图片
     *
     * @param file
     * @param context
     * @param imageView
     * @param defResourceId
     */
    public static void loadBlurImage(File file, final Context context, final ImageView imageView, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(file)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .bitmapTransform(new GlideBlurTransformation(context))
             .into(imageView);
    }

    /**
     * 加载旋转图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param rotateAngle
     * @param defResourceId
     */
    public static void loadRotateImage(String url, final Context context, final ImageView imageView, float rotateAngle, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(url)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .bitmapTransform(new GlideRotateTransformation(context, rotateAngle))
             .into(imageView);
    }

    /**
     * 加载旋转图片
     *
     * @param uri
     * @param context
     * @param imageView
     * @param rotateAngle
     * @param defResourceId
     */
    public static void loadRotateImage(Uri uri, final Context context, final ImageView imageView, float rotateAngle, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(uri)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .bitmapTransform(new GlideRotateTransformation(context, rotateAngle))
             .into(imageView);
    }

    /**
     * 加载旋转图片
     *
     * @param file
     * @param context
     * @param imageView
     * @param rotateAngle
     * @param defResourceId
     */
    public static void loadRotateImage(File file, final Context context, final ImageView imageView, float rotateAngle, int defResourceId) {
        Glide.with(context.getApplicationContext())
             .load(file)
             .placeholder(defResourceId)
             .error(R.drawable.default_image_failed)
             .bitmapTransform(new GlideRotateTransformation(context, rotateAngle))
             .into(imageView);
    }

    /**
     * 清除内存中的缓存 必须在UI线程中调用
     *
     * @param context
     */
    public static void clearMemory(Context context) {
        Glide.get(context).clearMemory();
    }

    /**
     * 清除磁盘中的缓存 必须在后台线程中调用，建议同时clearMemory()
     *
     * @param context
     */
    public static void clearDiskCache(Context context) {
        Glide.get(context).clearDiskCache();
    }
}
