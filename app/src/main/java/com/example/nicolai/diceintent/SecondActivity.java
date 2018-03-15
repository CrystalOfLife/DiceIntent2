package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class SecondActivity extends ListActivity {

    Die m_dice;
    DiceAdapter fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("DiceHistory");
        Intent intent = getIntent();
        String move = intent.getStringExtra("Dice");
        String[] relist = intent.getStringArrayExtra("relist");
        m_dice = new Die();

        fa = new DiceAdapter(this, R.layout.resultcell, m_dice.getAll());
        this.setListAdapter(fa);
        m_dice.die.add(new BEDiceHistory(move));
// the if move != null makes the next button  open a window without adding dies and values, but a bug appeared where we could only add 1 dice to the listview by doing so
       /**
         if (move != null)
        {
            m_dice.die.add(new BEDiceHistory(move));

        }
        */

        if (relist != null) {
            for (String e : relist) {
                m_dice.die.add(new BEDiceHistory(e.toString()));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String[] relist = intent.getStringArrayExtra("relist");
        if (relist != null) {
            for (String e : relist) {
                m_dice.die.add(new BEDiceHistory(e.toString()));
            }
        }
        fa.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onListItemClick(ListView parent,
                                View v, int position, long id) {
        String[] list = m_dice.getDice();
        onPause();
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtra("list", list);
        startActivity(intent);
    }
}