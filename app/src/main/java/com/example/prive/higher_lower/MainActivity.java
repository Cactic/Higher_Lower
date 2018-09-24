package com.example.prive.higher_lower;

import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] images;
    private ImageView imageView;
    private Random random;
    private int randomNumber, oldNumber;
    private int score = 0;
    private int highScore = 0;
    private FloatingActionButton lower;
    private FloatingActionButton higher;
    private TextView scoreView, highScoreView;

    ListView lv;
    private ArrayList<String> arraylist;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.ListView);
        arraylist = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arraylist);

        lv.setAdapter(adapter);
        random = new Random();
        scoreView = (TextView) findViewById(R.id.Score);
        scoreView.setText(Integer.toString(score));

        highScoreView = findViewById(R.id.HighScore);
        highScoreView.setText(Integer.toString(highScore) );


        lower = findViewById(R.id.lower);
        higher = findViewById(R.id.higher);


        imageView = (ImageView) findViewById(R.id.imageView);

        images = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4,
                R.drawable.d5, R.drawable.d6};

        randomNumber = generateRandomNumber();
        oldNumber = randomNumber;

        generateImage();

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomNumber = generateRandomNumber();
                generateImage();

                arraylist.add("You threw " + Integer.toString(randomNumber));
                adapter.notifyDataSetChanged();

                if (oldNumber > randomNumber) {
                    score ++;
                    Snackbar.make(view,"You win!",Snackbar.LENGTH_SHORT).show();
                } else {
                    score = 0;
                    Snackbar.make(view,"You lose!",Snackbar.LENGTH_SHORT).show();
                }
                scoreView.setText(Integer.toString(score));

                lv.setSelection(lv.getBottom());

                oldNumber = randomNumber;

                if(score > highScore){
                    highScore = score;
                    highScoreView.setText(Integer.toString(highScore));
                }
            }
        });
        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomNumber = generateRandomNumber();
                generateImage();

                arraylist.add("You threw " + Integer.toString(randomNumber));
                adapter.notifyDataSetChanged();


                if (oldNumber < randomNumber) {
                    score++;
                    Snackbar.make(view, "You win!", Snackbar.LENGTH_SHORT).show();
                }else{
                    score = 0;
                    Snackbar.make(view,"You lose!",Snackbar.LENGTH_SHORT).show();
                }
                scoreView.setText(Integer.toString(score));

                lv.setSelection(lv.getBottom());

                oldNumber = randomNumber;

                if(score > highScore){
                    highScore = score;
                    highScoreView.setText(Integer.toString(highScore));
                }

            }
        });
    }

    int generateRandomNumber() {
        return random.nextInt(6) + 1;
    }

    void generateImage() {
        Drawable drawable = getResources().getDrawable(images[randomNumber - 1]);
        imageView.setImageDrawable(drawable);
    }
}