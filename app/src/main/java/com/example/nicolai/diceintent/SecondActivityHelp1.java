package com.example.nicolai.diceintent;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**
 * Created by Nicolai on 01-03-2018.
 */

public class SecondActivityHelp1 extends ListActivity {
    Die die;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("DiceHistory1");

        die = new Die();

        String[] dice = die.getDice();

        ListAdapter adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        dice);

        setListAdapter(adapter);

    }
}
