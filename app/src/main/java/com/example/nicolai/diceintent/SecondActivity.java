package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SecondActivity extends ListActivity {

    Die m_friends;
    FriendAdapter fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Friend Activity 03");

        m_friends = new Die();

        fa = new FriendAdapter(this, R.layout.resultcell, m_friends.getAll());
        this.setListAdapter(fa);
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
        Toast.makeText(this, "Hi " + m_friends.getAll().get(position).getResult() + "! Have you done your homework?",
                Toast.LENGTH_LONG).show();
    }
}

class FriendAdapter extends ArrayAdapter<BEDiceHistory> {

    static String TAG = "LIST03";

    private ArrayList<BEDiceHistory> friends;
    private final int[] colours = {
            Color.parseColor("#AAAAAA"),
            Color.parseColor("#EEEEEE"),
            Color.parseColor("#435612")
    };


    public FriendAdapter(Context context, int textViewResourceId,
                         ArrayList<BEDiceHistory> friends) {
        super(context, textViewResourceId, friends);
        this.friends = friends;
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


        BEDiceHistory f = friends.get(position);

        TextView name = v.findViewById(R.id.diceHistoryResult);

        name.setText(f.getResult());

        return v;
    }
}