package com.example.android.playsound;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    Button buttonPlay;
    Button buttonStop;
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        buttonPlay = (Button) findViewById(R.id.buttonStart);
        buttonPlay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                mPlayer = MediaPlayer.create(getApplicationContext(),R.raw.kali);//Create MediaPlayer object with MP3 file under res/raw folder
                mPlayer.start();//Start playing the music
                buttonPlay.setText("Playing");
                buttonStop.setText("Stop");
            }
        });

        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mPlayer!=null && mPlayer.isPlaying()){//If music is playing already
                    mPlayer.stop();//Stop playing the music
                    buttonStop.setText("Stopping");
                    buttonPlay.setText("Start");
                }
            }
        });
    }
}
