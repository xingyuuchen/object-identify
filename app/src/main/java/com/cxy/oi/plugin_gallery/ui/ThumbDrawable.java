package com.cxy.oi.plugin_gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cxy.oi.kernel.app.OIApplicationContext;
import com.cxy.oi.kernel.util.Log;
import com.cxy.oi.kernel.util.Util;
import com.cxy.oi.plugin_gallery.Utils;
import com.cxy.oi.plugin_gallery.model.GalleryCore;
import com.cxy.oi.plugin_gallery.model.ReadBitmapFromFileTask;


public class ThumbDrawable extends Drawable {
    private static final String TAG = "ThumbDrawable";

    private static final Paint paint = new Paint();
    static {
        paint.setAntiAlias(true);
    }

    private ImageView iv;
    private Bitmap bitmap;
    private Rect srcRect = new Rect();
    private long origId;
    private String path;
    private boolean isBlur;


    public ThumbDrawable(ImageView iv) {
        this(iv, false);
    }

    public ThumbDrawable(ImageView iv, boolean isBlur) {
        this.iv = iv;
        this.isBlur = isBlur;
    }

    public static void attach(ImageView iv, String path) {
        attach(iv, -1, path, false);
    }

    public static void attach(ImageView iv, String path, boolean isBlur) {
        attach(iv, -1, path, isBlur);
    }

    public static void attach(final ImageView iv, final long origId, String path) {
        attach(iv, origId, path, false);
    }

    public static void attach(final ImageView iv, final long origId, String path, boolean isBlur) {
        if (origId <= 0 && Util.isNullOrNil(path)) {
            return;
        }
        final Drawable drawable = iv.getDrawable();
        final ThumbDrawable thumb;
        final boolean isNew;
        if (drawable instanceof ThumbDrawable) {
            thumb = (ThumbDrawable) drawable;
            thumb.bitmap = null;
            isNew = false;
        } else {
            thumb = new ThumbDrawable(iv, isBlur);
            isNew = true;
        }

        final String cacheKey = Utils.getCacheKey(origId, path, thumb.isBlur);
        thumb.origId = origId;
        thumb.path = path;
        Bitmap bm = GalleryCore.getMediaCacheService().getBitMapFromCache(cacheKey);
        if (bm != null) {
            thumb.bitmap = bm;
            if (isNew) {
                iv.setImageDrawable(thumb);
            } else {
                iv.invalidateDrawable(thumb);
            }
            return;
        }

        if (thumb.bitmap == null) {
            GalleryCore.getMediaWorkerThread().startDecode(new ReadBitmapFromFileTask(origId, path,
                    new ReadBitmapFromFileTask.IOnBitmapGet() {
                        @Override
                        public void onBitmapGet(Bitmap bitmap) {
                            if (bitmap != null) {
                                if (thumb.isBlur) {
                                    bitmap = Utils.blurBitmap(OIApplicationContext.getContext(), bitmap, 25f);
                                }
                                thumb.bitmap = bitmap;
                                if (isNew) {
                                    iv.setImageDrawable(thumb);
                                } else {
                                    iv.invalidateDrawable(thumb);  // 异步，必须invalidate
                                }
                            }
                        }

                        @Override
                        public void doInBackground(Bitmap bitmap) {
                            if (bitmap != null && !Util.isNullOrNil(cacheKey)) {
                                if (thumb.isBlur) {
                                    bitmap = Utils.blurBitmap(OIApplicationContext.getContext(), bitmap, 25f);
                                }
                                GalleryCore.getMediaCacheService().saveBitmapToMemCache(cacheKey, bitmap);
                            }
                        }
                    }));
        }
    }


    @Override
    public void draw(@NonNull Canvas canvas) {
        if (bitmap == null || bitmap.isRecycled()) {
            Log.i(TAG, "bitmap == null || bitmap.isRecycled()!  origId: %s", origId);
            return;
        }
        resizeSrcRect();
        canvas.drawBitmap(bitmap, srcRect, getBounds(), paint);
    }

    private void resizeSrcRect() {
        if (bitmap == null) {
            return;
        }
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        if (w > h) {
            srcRect.top = 0;
            srcRect.bottom = h;
            srcRect.left = (w - h) / 2;
            srcRect.right = w - srcRect.left;
        } else {
            srcRect.left = 0;
            srcRect.right = w;
            srcRect.top = (h - w) / 2;
            srcRect.bottom = h - srcRect.top;
        }
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

}
