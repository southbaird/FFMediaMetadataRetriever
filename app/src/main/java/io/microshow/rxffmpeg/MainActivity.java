package io.microshow.rxffmpeg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        imageView = findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
                    mmr.setDataSource("http://vfx.mtime.cn/Video/2019/06/28/mp4/190628075308350550.mp4");
                    Bitmap bitmap = mmr.getFrameAtTime(1000);
                    mmr.release();
                    imageView.setImageBitmap(bitmap);
                } catch (IllegalArgumentException e) {
                    Log.d(TAG, "参数异常，地址错误");
                }
            }
        });
    }

}
