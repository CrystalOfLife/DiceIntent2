package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Die {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
    String formattedDate = df.format(c.getTime());

    ArrayList<BEDiceHistory> die;

    public Die()
    {
        die = new ArrayList<BEDiceHistory>();


    }

    public ArrayList<BEDiceHistory> getAll()
    { return die; }

    public String[] getDice()
    {
        String[] res = new String[die.size()];
        for(int idx=0; idx < res.length; idx++)
            res[idx] = die.get(idx).getResult();
        return res;
    }
}
