package br.com.arthur.crudsimplesandroid.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

/**
 * Created by arthur on 09/08/17.
 */

public class AlertUtils {

    public void messageDelete(Context context, int icon, String title, String msg, DialogInterface.OnClickListener positiveBtn, DialogInterface.OnClickListener negativeBtn){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setIcon(icon);
        builder.setTitle(title);
        builder.setMessage(msg);

        builder.setPositiveButton("Sim", positiveBtn);
        builder.setNegativeButton("Não", negativeBtn);
        builder.show();

    }
}
