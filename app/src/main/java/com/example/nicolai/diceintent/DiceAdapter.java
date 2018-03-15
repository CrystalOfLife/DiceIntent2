package com.example.nicolai.diceintent;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nicolai on 15-03-2018.
 */

public class DiceAdapter extends ArrayAdapter<BEDiceHistory> {

    private ArrayList<BEDiceHistory> die;
    private final int[] colours = {
            Color.parseColor("#AAAAAA"),
            Color.parseColor("#EEEEEE")
    };


    public DiceAdapter(Context context, int textViewResourceId,
                       ArrayList<BEDiceHistory> die) {
        super(context, textViewResourceId, die);
        this.die = die;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if (v == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            v = li.inflate(R.layout.resultcell, parent,false);
        }

        v.setBackgroundColor(colours[position % colours.length]);


        BEDiceHistory f = die.get(position);

        TextView name = v.findViewById(R.id.diceHistoryResult);

        name.setText(f.getResult());

        return v;
    }
}
