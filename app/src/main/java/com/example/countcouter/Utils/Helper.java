package com.example.countcouter.Utils;

import android.content.Context;
import android.content.Intent;

public class Helper {
    Context context;
    Intent intent;

    public Helper(){
    }

    public Helper(Context context){
        this.context = context;
    }

    public Helper(Context context, Intent intent){
        this.context = context;
        this.intent = intent;
    }
}
