package com.suffixit.videocaching;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.danikula.videocache.HttpProxyCacheServer;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    String videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*videoView=findViewById(R.id.vvVideo);
       // HttpProxyCacheServer proxy = getProxy();
        String proxyUrl = App.getProxy(this).getProxyUrl(videoUrl);
        videoView.setVideoPath(proxyUrl);

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/
    }

}