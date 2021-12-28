package com.example.countcouter.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.countcouter.MainActivity;

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

    public void toastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void toastMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void logMessage(Class TAGClass, String errorMessage){
        Log.d("com.example.echat." + TAGClass.getName(), errorMessage);
    }

    public void gotoSendActivity(String message){
        intent = new Intent(context, MainActivity.class);
        intent.putExtra("send", message);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

}
