package com.example.birat.major_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class disgustActivity extends YouTubeBaseActivity {


    private static final String TAG = "sad";
    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disgust);
        Log.d(TAG,"onCreate:Starting.");

        btnPlay = (Button) findViewById(R.id.playButton);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.songPlay);

        mOnInitializedListener =  new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onCLick: Done initialising");
                /*List<String> videoList = new ArrayList<>();
                videoList.add("8SbUC-UaAxE");//betn equals and & sign
                videoList.add("-EzURpTF5c8");
                youTubePlayer.loadVideos(videoList);*/

                youTubePlayer.loadPlaylist("PL1VuYyZcPYIJTP3W_x0jq9olXviPQlOe1");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onCLick: Failed to initialise");
            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: Initialising player");
                mYouTubePlayerView.initialize(SongConfig.getApiKey(),mOnInitializedListener);

            }
        });
    }
}
