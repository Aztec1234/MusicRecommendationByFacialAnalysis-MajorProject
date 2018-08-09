package com.example.birat.major_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity {

    public Button button;
    public ImageButton happyBtn,angryBtn,sadBtn,fearBtn,disgustBtn,surpriseBtn,neuralBtn;


    public void init(){
        button = (Button)findViewById(R.id.AnalyseBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doi = new Intent(Main2Activity.this,Analyse.class);
                startActivity(doi);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        happyBtn = (ImageButton)findViewById(R.id.imageButton3);
        angryBtn = (ImageButton)findViewById(R.id.imageButton2);
        fearBtn = (ImageButton)findViewById(R.id.imageButton);
        disgustBtn = (ImageButton)findViewById(R.id.imageButton5);
        sadBtn = (ImageButton)findViewById(R.id.imageButton4);
        neuralBtn = (ImageButton)findViewById(R.id.imageButton6);
        surpriseBtn = (ImageButton)findViewById(R.id.imageButton7);


        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo = new Intent(Main2Activity.this,happy.class);
                startActivity(opo);
            }
        });

        disgustBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo = new Intent(Main2Activity.this,disgustActivity.class);
                startActivity(opo);
            }
        });

       neuralBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo = new Intent(Main2Activity.this,NeutralActivity.class);
                startActivity(opo);
            }
        });

        surpriseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo = new Intent(Main2Activity.this,SurpriseActivity.class);
                startActivity(opo);
            }
        });

        fearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo1 = new Intent(Main2Activity.this,love.class);
                startActivity(opo1);
            }
        });


        angryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo2 = new Intent(Main2Activity.this,angry.class);
                startActivity(opo2);
            }
        });


        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opo3 = new Intent(Main2Activity.this,sad.class);
                startActivity(opo3);
            }
        });

    }


}
