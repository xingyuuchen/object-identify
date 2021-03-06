package com.cxy.oi.plugin_gallery.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxy.oi.R;
import com.cxy.oi.kernel.constants.ConstantsUI;
import com.cxy.oi.kernel.util.Log;
import com.cxy.oi.kernel.util.Util;
import com.cxy.oi.plugin_gallery.model.MediaItem;

import static com.cxy.oi.kernel.constants.ConstantsUI.AlbumPreviewUI.REQUEST_PERMISSION;

public class AlbumPreviewUI extends Activity {
    private static final String TAG = "OI.AlbumPreviewUI";

    private RecyclerView gallery;
    private AlbumAdapter adapter;
    private TextView btnConfirm;
    private TextView btnPreview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "[onCreate]");
        setContentView(R.layout.gallery_preview);
        checkPermissions();

    }

    private void init() {
        Log.i(TAG, "[init]");
        gallery = findViewById(R.id.album_recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,
                ConstantsUI.AlbumPreviewUI.SPAN_COUNT);
        gallery.setLayoutManager(layoutManager);
        adapter = new AlbumAdapter(this);
        gallery.setAdapter(adapter);
        btnPreview = findViewById(R.id.btn_preview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaItem selectedItem = adapter.getSelectedItem();
                if (selectedItem != null) {
                    onImageSelected(selectedItem.originalPath);
                }
            }
        });

        btnConfirm.setEnabled(false);

        adapter.setOnItemClickListener(new AlbumAdapter.IOnItemClickListener() {
            @Override
            public void onItemClick(int position, MediaItem mediaItem) {
                int selectImgIdx = adapter.getSelectImgIdx();
                boolean isSelect = selectImgIdx != -1;
                btnConfirm.setEnabled(isSelect);

            }
        });
    }


    private void onImageSelected(String imgPath) {
        Intent intent = new Intent();
        intent.putExtra(ConstantsUI.AlbumPreviewUI.KSELECT_IMG_PATH, imgPath);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }


    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION);
        } else {
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            if (Util.isNullOrNil(grantResults)
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "user refuse to grant!!");
                finish();
                return;
            }
            init();
        }
    }
}
