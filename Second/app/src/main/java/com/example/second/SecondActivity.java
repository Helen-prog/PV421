package com.example.second;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button secondBtn = findViewById(R.id.button2);
        ImageView image = findViewById(R.id.boyImage);

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AnimationDrawable)image.getDrawable()).start();
//               Animation out = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_alpha);
//               image.startAnimation(out);
                Animation translate = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.anim_translate);
                image.startAnimation((translate));
            }
        });

        ImageView myImageView = findViewById(R.id.boyImage0);
        Button buttonRotateCenter = findViewById(R.id.rotateCenter);
        Button buttonRotateCorner = findViewById(R.id.rotateCorner);

        Animation animationRotateCenter = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.rotate_center);
        Animation animationRotateCorner = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.rotate_corner);

        buttonRotateCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.startAnimation(animationRotateCenter);
            }
        });

        buttonRotateCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.startAnimation(animationRotateCorner);
            }
        });

        Animation scale = AnimationUtils.loadAnimation(this, R.anim.shrink);
        secondBtn.startAnimation(scale);
    }
}