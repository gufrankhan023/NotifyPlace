package com.android.placenotification.utilities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;

import com.android.placenotification.R;

/**
 * Created by Gufran on 10/5/2017.
 */

public class CommonMethods {
    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        boolean isConnected = connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

        if (!isConnected) {
            getInternetAlertDialog(context, "Please check your internet connection or try again later.", "");
        }

        return isConnected;
    }

    public static ProgressDialog showProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.show();
        dialog.setContentView(R.layout.view_progressbar);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        return dialog;
    }

    public static void dismissDialog(ProgressDialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static void getAlertDialog(Context context, String Message, String tag) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("");
        dialog.setMessage(Message);
        dialog.setCancelable(false);

        dialog.setPositiveButton("Ok",

                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                }

        );

        Dialog dial = dialog.create();
        dial.show();

    }

    public static void getInternetAlertDialog(final Context context, String Message, String tag) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("");
        dialog.setMessage(Message);
        dialog.setCancelable(false);

        dialog.setNegativeButton("Ok",

                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }


        );

        dialog.setPositiveButton("Try again",

                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (CommonMethods.isNetworkAvailable(context)) ;
                    }
                }
        );

        Dialog dial = dialog.create();
        dial.show();

    }



}
