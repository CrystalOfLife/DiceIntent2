package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


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
        if (relist != null) {
            for (String e : relist) {
                m_dice.die.add(new BEDiceHistory(e.toString()));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        fa.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView parent,
                                View v, int position, long id) {
        // position is in the list!
        String[] list = m_dice.getDice();
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtra("list", list);
        startActivity(intent);
    }
}

class DiceAdapter extends ArrayAdapter<BEDiceHistory> {

    static String TAG = "LIST03";

    private ArrayList<BEDiceHistory> die;
    private final int[] colours = {
            Color.parseColor("#AAAAAA"),
            Color.parseColor("#EEEEEE")
    };


    public DiceAdapter(Context context, int textViewResourceId,
                         ArrayList<BEDiceHistory> die) {
        super(context, textViewResourceId, die);
        this.die = die;
        //die.add(new BEDiceHistory());
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if (v == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            v = li.inflate(R.layout.resultcell, parent,false);
            Log.d(TAG, "Position: " + position + " View created");
        }
        else
            Log.d(TAG, "Position: " + position + " View Reused");

        v.setBackgroundColor(colours[position % colours.length]);


        BEDiceHistory f = die.get(position);

        TextView name = v.findViewById(R.id.diceHistoryResult);

        name.setText(f.getResult());

        return v;
    }
}