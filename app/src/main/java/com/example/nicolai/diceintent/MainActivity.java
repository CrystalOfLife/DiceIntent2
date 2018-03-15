package com.example.nicolai.diceintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Die m_dice;

    ImageView dice1, dice2;
    Button Roll, btnNext;;
    TextView History1, History2, History3, History4, History5;
    int[] images = {
            R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    };
    int PickedImage, holdPicked;
    Random r;
    String[] returnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Roll = findViewById(R.id.Roll);
        btnNext = findViewById(R.id.btnNext);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        History1 = findViewById(R.id.History1);
        History2 = findViewById(R.id.History2);
        History3 = findViewById(R.id.History3);
        History4 = findViewById(R.id.History4);
        History5 = findViewById(R.id.History5);
        r = new Random();

        Intent intent = getIntent();
        String[] relist = intent.getStringArrayExtra("list");
        returnList = relist;

        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
       /* Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearHistory();
            }
        });*/
        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onClickNext();
            }
        });
    }

    private void randomDice()
    {
        PickedImage = r.nextInt(images.length);
    }

    private void rollDice()
    {
        randomDice();
        dice1.setImageResource(images[PickedImage]);
        holdPicked = PickedImage;
        randomDice();
        dice2.setImageResource(images[PickedImage]);
        updateHistory();
        onClickNext();
    }

    private void updateHistory()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String formattedDate = df.format(c.getTime());
        History5.setText(History4.getText());
        History4.setText(History3.getText());
        History3.setText(History2.getText());
        History2.setText(History1.getText());
        History1.setText((holdPicked + 1) + " + " + (1 + PickedImage) + " = " + (holdPicked + 1 + 1 + PickedImage + " " + formattedDate ));
        //m_dice.die.add(new BEDiceHistory(History1.getText().toString()));
    }

    private void clearHistory()
    {
        History1.setText("");
        History2.setText("");
        History3.setText("");
        History4.setText("");
        History5.setText("");
    }

    public void onClickNext() {
        String move = History1.getText().toString();
        String[] relist = returnList;
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        intent.putExtra("relist", relist);
        intent.putExtra("Dice", move);
        startActivity(intent);
    }
}
