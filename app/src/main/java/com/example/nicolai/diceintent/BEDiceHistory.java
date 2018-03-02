package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class BEDiceHistory implements Serializable{

    String result;

    public BEDiceHistory(String diceResult)
    {
        result = diceResult;
    }

    public String getResult() { return result; }


}
