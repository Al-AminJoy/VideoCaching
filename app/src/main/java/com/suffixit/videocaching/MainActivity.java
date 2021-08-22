package com.suffixit.videocaching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.google.android.exoplayer2.MediaItem;
import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    String videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";
    PlayerView playerView;
    ProgressBar progressBar;
    ImageView btFullscreen;
    SimpleExoPlayer simpleExoPlayer;
     boolean flag = false;
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

       /* playerView = findViewById(R.id.playerView);
        progressBar = findViewById(R.id.progress_bar);
        btFullscreen = playerView.findViewById(R.id.bt_fullscreen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //String proxyUrl = App.getProxy(this).getProxyUrl(videoUrl);
        Uri videoURL = Uri.parse(proxyUrl);
        LoadControl loadControl = new DefaultLoadControl();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(MainActivity.this,trackSelector,loadControl);
        DefaultHttpDataSourceFactory factory = new DefaultHttpDataSourceFactory("exoplayer_video");
        ExtractorsFactory exoPlayerFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource = new ExtractorMediaSource(videoURL,factory,exoPlayerFactory,null,null);

        playerView.setPlayer(simpleExoPlayer);
        playerView.setKeepScreenOn(true);
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                  if (playbackState == Player.STATE_BUFFERING){
                      progressBar.setVisibility(View.VISIBLE);
                  }
                  else if(playbackState == Player.STATE_READY){
                      progressBar.setVisibility(View.GONE);

                  }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });
    btFullscreen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (flag){
                btFullscreen.setImageDrawable(getResources().getDrawable(R.drawable.ic_fullscreen));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                flag = false;
            }
            else {
                btFullscreen.setImageDrawable(getResources().getDrawable(R.drawable.icbaseline_fullscreen_exit));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                flag = true;
            }
        }
    });*/

        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();

        PlayerView playerView = findViewById(R.id.exoPlayerView);

        playerView.setPlayer(simpleExoPlayer);
        String proxyUrl = App.getProxy(this).getProxyUrl(videoUrl);

        MediaItem mediaItem = MediaItem.fromUri(proxyUrl);
        simpleExoPlayer.addMediaItem(mediaItem);

        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

    }

    @Override
    protected void onPause() {
        super.onPause();
       /* simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.getPlaybackState();*/
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       /* simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayer.getPlaybackState();*/
    }
}