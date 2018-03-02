package com.example.nicolai.diceintent;

/**
 * Created by Nicolai on 01-03-2018.
 */

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BEDiceHistory implements Serializable{

    String result;
    Date currentTime = Calendar.getInstance().getTime();
    public BEDiceHistory(String diceResult)
    {
        result = diceResult;
        currentTime.toString();

    }

    public String getResult() { return result; }


}
