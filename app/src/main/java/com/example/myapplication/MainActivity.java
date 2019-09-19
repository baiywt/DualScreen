package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.hardware.display.DisplayManager;
import android.app.Presentation;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.VideoView;
import android.widget.MediaController;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    private DifferentDisplay presentation;
    private Display[] presentationDisplays;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        DisplayManager displayManager = (DisplayManager)  getSystemService(Context.DISPLAY_SERVICE);
        //获取屏幕数量
        presentationDisplays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        if (presentationDisplays != null) {
           presentation = new DifferentDisplay(this, presentationDisplays[presentationDisplays.length - 1]);
        }
        presentation.show();
        videoView = presentation.videoView;
        File videofile =new File("/sdcard/big_buck_bunny_4k_H264_30fps.mp4");
        videoView.setVideoPath(videofile.getAbsolutePath());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.pause();
            }
        });

    }
}
