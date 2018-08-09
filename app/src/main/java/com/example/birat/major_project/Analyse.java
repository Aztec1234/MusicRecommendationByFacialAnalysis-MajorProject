package com.example.birat.major_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Analyse extends AppCompatActivity {

    public Button captureBtn,chooseBtn,confirmBtn;

    public ImageView imageView;

    static final int CAM_REQUEST = 1;
    private static final int GALLERY_INTENT = 2;
    int SELECT_FILE = 0;

    public StorageReference mStorage;//for sending photos to firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);

        mStorage = FirebaseStorage.getInstance().getReference();

        captureBtn = (Button) findViewById(R.id.takePhoto);
        chooseBtn = (Button) findViewById(R.id.choosebtn);
        confirmBtn = (Button) findViewById(R.id.confirmBtn);

        imageView = (ImageView) findViewById(R.id.imageView);

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, CAM_REQUEST);
            }
        });

        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicFromGallery();
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (imageView.getDrawable() == null) {
                    Toast.makeText(Analyse.this, "First Capture or Choose Image", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent newIntend = new Intent(Analyse.this, EmotionActivity.class);
                    startActivity(newIntend);
                }
            }
        });
    }


    public void takePicFromGallery(){
             Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
             intent.setType("image/*");
             startActivityForResult(intent.createChooser(intent,"Select File"),SELECT_FILE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == Activity.RESULT_OK ){
            if(requestCode == CAM_REQUEST){
                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bmp);
                Uri uri = data.getData();

                StorageReference filepath = mStorage.child("Photos").child("images.jpg");
                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Analyse.this,"Done",Toast.LENGTH_LONG).show();
                    }
                });
            }
            else if(requestCode == SELECT_FILE){
                Uri uri = data.getData();
                imageView.setImageURI(uri);
                StorageReference filepath = mStorage.child("Photos").child("images.jpg");
                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Analyse.this,"Done",Toast.LENGTH_LONG).show();
                    }
                });
            }

            }
           else if (requestCode == GALLERY_INTENT ){
                Uri uri = data.getData();
                imageView.setImageURI(uri);

                StorageReference filepath = mStorage.child("Photos").child("images.jpg");
                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Analyse.this,"Done",Toast.LENGTH_LONG).show();
                    }
                });
           }
        }
    }



