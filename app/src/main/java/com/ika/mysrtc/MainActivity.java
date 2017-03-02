package com.ika.mysrtc;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {

    public void ShowRecScr(View view) {
        
        Intent intent = new Intent(this, Record.class);
        startActivity(intent);
    }


    private MediaRecorder myRecorder;
    private String outputFile = null;
    private Button startBtn;
    private Button uploadBtn; //************NOT implemented yet*****************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "SRTCaudio.3gpp";

        myRecorder = new MediaRecorder();
        myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myRecorder.setOutputFile(outputFile);

        startBtn = (Button)findViewById(R.id.myRecordBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(view);
            }
        });
    }

    public void start (View view){
        try{
            myRecorder.prepare();
            myRecorder.start();
        } catch (IllegalStateException e){

            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "Recording started",
                Toast.LENGTH_SHORT);

    }



}
