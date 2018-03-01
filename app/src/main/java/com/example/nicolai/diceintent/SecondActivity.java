package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        BEDiceHistory p = (BEDiceHistory) extras.getSerializable("Dice");
        if (p == null)
        {
            p = new BEDiceHistory("No Dice");
        }

        String msg = p.getResult();
        TextView header = (TextView)findViewById(R.id.tvInfo);

        header.setText(msg);
    }

    @Override protected void onPause()
    {   super.onPause();
    }
}