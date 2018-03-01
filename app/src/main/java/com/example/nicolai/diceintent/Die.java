package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import java.util.ArrayList;

public class Die {

    ArrayList<BEDiceHistory> die;

    public Die()
    {
        die = new ArrayList<BEDiceHistory>();
        die.add(new BEDiceHistory("3 +1"));
        die.add(new BEDiceHistory("6 + 6"));
        die.add(new BEDiceHistory("2 + 4"));
        die.add(new BEDiceHistory("5 + 2"));
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
