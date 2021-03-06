package com.cxy.oi.plugin_gallery;

import android.widget.ImageView;

import com.cxy.oi.plugin_gallery.ui.ThumbDrawable;

public class PluginGallery implements IPluginGallery {

    @Override
    public void attachThumbDrawable(ImageView iv, String path) {
        ThumbDrawable.attach(iv, path);
    }

    @Override
    public void attachThumbDrawable(ImageView iv, String path, boolean isBlur) {
        ThumbDrawable.attach(iv, path, isBlur);
    }

    @Override
    public void attachThumbDrawable(ImageView iv, long origId, String path) {
        ThumbDrawable.attach(iv, origId, path);
    }

    @Override
    public void attachThumbDrawable(ImageView iv, long origId, String path, boolean isBlur) {
        ThumbDrawable.attach(iv, origId, path, isBlur);
    }

    @Override
    public void doWhenBoot() {

    }
}
