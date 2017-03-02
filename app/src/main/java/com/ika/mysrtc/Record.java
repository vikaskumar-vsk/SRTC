package com.ika.mysrtc;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by vikas on 02-03-2017.
 */

public class Record extends Activity {

    private MediaPlayer myPlayer;
    private MediaRecorder myRecorder;
    private Button stopBtn;
    private Button playBtn;
    private Button stopPlayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_layout);

        stopBtn = (Button) findViewById(R.id.myStopRecBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stop(view);
            }
        });
    }

    public void stop(View view){
        try{
            myRecorder.stop();
            myRecorder.release();
            myRecorder = null;

            stopBtn.setEnabled(false);
            playBtn.setEnabled(true);

            Toast.makeText(getApplicationContext(), "Recording stopped", Toast.LENGTH_SHORT).show();
    } catch (IllegalStateException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
