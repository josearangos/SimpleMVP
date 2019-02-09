package com.gaston.macbook.simplemvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.gaston.macbook.simplemvp.BuildConfig;
import com.gaston.macbook.simplemvp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ISSLive extends YouTubeBaseActivity {

    private String VIDEO_ID = "dVTzaXmYm_s";
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_isslive);

        bindViews();
        initVideo();

    }

    private void bindViews(){

        youTubePlayerView = findViewById(R.id.isslive_youtube_player);

    }

    private void initVideo(){

        youTubePlayerView.initialize(BuildConfig.YoutubeApiKey, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    youTubePlayer.loadVideo(VIDEO_ID);
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(ISSLive.this, getString(R.string.youtube_video_load_failed), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
