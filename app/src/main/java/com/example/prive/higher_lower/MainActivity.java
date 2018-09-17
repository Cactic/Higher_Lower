package com.example.prive.higher_lower;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] images;
    private ImageView imageView;
    private Random random;
    private int randomNumber, newNumber, score, highScore;
    private Button lower;
    private Button Higher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4,
                R.drawable.d5, R.drawable.d6};

        random = new Random();
        randomNumber = random.nextInt(6) + 1;


        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(images[randomNumber - 1]);



    }

}