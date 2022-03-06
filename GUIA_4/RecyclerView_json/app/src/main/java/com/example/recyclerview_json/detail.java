package com.example.recyclerview_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class detail extends AppCompatActivity {

    ImageView Imagedetails;
    TextView pathology ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Dogs dog = (Dogs) getIntent().getSerializableExtra("detail");

        Imagedetails = (ImageView) findViewById(R.id.Imagedetails);

        pathology = (TextView) findViewById(R.id.pathology);


        pathology.setText(dog.getDescription());
        Glide.with(this).load(dog.getImg()).into(Imagedetails);
    }
}