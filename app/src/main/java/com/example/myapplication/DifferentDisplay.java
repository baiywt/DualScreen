package com.example.myapplication;

import android.app.Presentation;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.VideoView;

//import com.remixdemo.media.IjkVideoView;

/**
 * Created by waynian on 2017/9/6.
 */

public class DifferentDisplay extends Presentation {
    public VideoView videoView;

    public DifferentDisplay(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_display);

        videoView = (VideoView ) findViewById(R.id.video_view);

    }
}