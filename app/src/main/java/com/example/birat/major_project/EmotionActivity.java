package com.example.birat.major_project;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class EmotionActivity extends AppCompatActivity {

    public FirebaseFirestore mFirestore; //for receiving emotion from firebase
    public static final String FIRE_LOG = "Fire_log";

    public String emotion,hola;

    private DatabaseReference mDatabase;

    private Button emoBtn,PlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);

        emoBtn = (Button) findViewById(R.id.emoBtn);
        PlBtn = (Button) findViewById(R.id.playB);

        mFirestore = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        emoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(EmotionActivity.this,"Fetching Emotion...",Toast.LENGTH_LONG).show();
                Toast.makeText(EmotionActivity.this,"Fetching Emotion...",Toast.LENGTH_LONG).show();
                Toast.makeText(EmotionActivity.this,"Fetching Emotion...",Toast.LENGTH_LONG).show();
                Toast.makeText(EmotionActivity.this,"Fetching Emotion...",Toast.LENGTH_LONG).show();
                //delay for 10seconds

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDatabase.child("user").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                                String value = dataSnapshot.getValue(String.class);
                                hola = value;
                                Toast.makeText(EmotionActivity.this, hola, Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                        // Magic here

                        /*mFirestore.collection("user").document("emotion").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.isSuccessful()) {
                            DocumentSnapshot documentSnapshot = task.getResult();
                            if (documentSnapshot.exists() && documentSnapshot != null) {
                                emotion = documentSnapshot.getString("emotion");
                                Toast.makeText(EmotionActivity.this, emotion, Toast.LENGTH_LONG).show();
                                hola = String.valueOf(emotion);
                                }
                        }
                        else{
                            Log.d(FIRE_LOG,"Error:" + task.getException().getMessage());
                        }
                    }
                });*/
                    }
                }, 10000); // Millisecond 1000 = 1 sec
            }
        });

       PlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(EmotionActivity.this, hola, Toast.LENGTH_LONG).show();

                 if(hola.equals("happy")){
                     Intent happyAct = new Intent(EmotionActivity.this, happy.class);
                     startActivity(happyAct);

                 }
                if(hola.equals("angry")){
                    Intent angerAct = new Intent(EmotionActivity.this, angry.class);
                    startActivity(angerAct);

                 }
                if(hola.equals("disgust")){
                    Intent disAct = new Intent(EmotionActivity.this, disgustActivity.class);
                    startActivity(disAct);

                }
                if(hola.equals("fear")){
                    Intent feAct = new Intent(EmotionActivity.this, love.class);
                    startActivity(feAct);

                }
                if(hola.equals("sad")){
                    Intent sadAct = new Intent(EmotionActivity.this, sad.class);
                    startActivity(sadAct);

                }
                if(hola.equals("surprise")){
                    Intent surpAct = new Intent(EmotionActivity.this, SurpriseActivity.class);
                    startActivity(surpAct);

                }
                if(hola.equals("neutral")){
                    Intent neutralAct = new Intent(EmotionActivity.this,NeutralActivity.class);
                    startActivity(neutralAct);

                }
            }

       });

    }
}
