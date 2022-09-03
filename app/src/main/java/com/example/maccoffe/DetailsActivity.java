package com.example.maccoffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "checkmoudel";
ImageView imageView;
TextView textViewname, textViewprize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView=findViewById(R.id.image_Details);
        textViewname=findViewById(R.id.text_name);
        textViewprize=findViewById(R.id.text_prize);


        SandwichesMoudel sandwichesMoudel= (SandwichesMoudel) getIntent().getSerializableExtra("sandwich");

        Log.i(TAG,"onCreate"+sandwichesMoudel.toString());

        textViewname.setText(sandwichesMoudel.getName());
        textViewprize.setText("Price: "+String.valueOf(sandwichesMoudel.getPrize())+" EGP");
        Picasso.get().load(sandwichesMoudel.getImageUrl()).placeholder(R.drawable.ic_launcher_foreground).into(imageView);



    }
}