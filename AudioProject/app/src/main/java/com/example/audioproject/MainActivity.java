package com.example.audioproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video_view;
    Button btnToggle;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            video_view = findViewById(R.id.videoView2);

            String path = "android.resource://" + getPackageName() + "/" + R.raw.mivideo;
            Uri uri = Uri.parse(path);
            video_view.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            this.video_view.setMediaController(mediaController);
            mediaController.setAnchorView(this.video_view);


            btnToggle = (Button) findViewById(R.id.btnToggle);


            btnToggle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Musica();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });


            video_view.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Musica() {

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.fuckingbestiallados);
        mediaPlayer.start();

    }
}
