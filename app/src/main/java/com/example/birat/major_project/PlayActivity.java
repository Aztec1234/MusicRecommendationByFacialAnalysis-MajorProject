package com.example.birat.major_project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.File;
import java.util.ArrayList;

//public class PlayActivity  extends ActionBarActivity implements View.OnClickListener  {

public class PlayActivity  extends AppCompatActivity {
    static MediaPlayer mp;
    ArrayList<File> mySongs;
    int position;
    Uri u;
   // Thread updateSeekBar;

    SeekBar sb;
    Button pbtn, prbtn, nbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);/*
        pbtn = (Button) findViewById(R.id.pauseBtn);
        prbtn = (Button) findViewById(R.id.prevBtn);
        nbtn = (Button) findViewById(R.id.nextBtn);

        pbtn.setOnClickListener(this);
        prbtn.setOnClickListener(this);
        nbtn.setOnClickListener(this);*/

      //  sb = (SeekBar) findViewById(R.id.seekBar2);
       /* updateSeekBar = new Thread(){
            @Override
            public void run(){
                int totalDuration = mp.getDuration();
                int currentPosition = 0;
                while (currentPosition < totalDuration){
                    try{
                        sleep(500);
                        currentPosition = mp.getCurrentPosition();
                        sb.setProgress(currentPosition);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        };
*/
       /* if(mp!= null){
            mp.stop();
            mp.release();
        }


        Intent i = getIntent();
        Bundle b = i.getExtras();
        ArrayList<File> mySongs = (ArrayList) b.getParcelableArrayList("songlist");
        position = b.getInt("pos", 0);
        //Universal Resource Indicator
        u = Uri.parse(mySongs.get(position).toString());
        mp = MediaPlayer.create(getApplicationContext(), u);
        mp.start();*/
        //sb.setMax(mp.getDuration());
       /* updateSeekBar.start();

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });*/
    }

  /*  @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.pauseBtn:
                if (mp.isPlaying()) {
                    pbtn.setText(">");
                    mp.pause();
                } else {
                    pbtn.setText("||");
                    mp.start();
                }
                break;
            case R.id.nextBtn:
                mp.stop();
                mp.release();
                position = (position + 1) % mySongs.size();
                u = Uri.parse(mySongs.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                //sb.setMax(mp.getDuration());
                break;
            case R.id.prevBtn:
                mp.stop();
                mp.release();
                position = (position - 1 < 0) ? mySongs.size() - 1 : position - 1;
                u = Uri.parse(mySongs.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                //sb.setMax(mp.getDuration());
                break;

        }
    }
*/
}

