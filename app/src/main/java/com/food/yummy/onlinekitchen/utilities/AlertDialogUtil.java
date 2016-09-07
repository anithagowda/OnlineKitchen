package com.food.yummy.onlinekitchen.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by harry on 9/6/16.
 */
public class AlertDialogUtil {

    public static void showAlertDialogWithOK(String title, String message, final Context context, final boolean exitActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (exitActivity) {
                    Activity activity = (Activity)context;
                    activity.finish();
                }
            }
        });
    }
}
