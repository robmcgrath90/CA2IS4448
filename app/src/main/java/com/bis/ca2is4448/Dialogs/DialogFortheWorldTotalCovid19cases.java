package com.bis.ca2is4448.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFortheWorldTotalCovid19cases extends AppCompatDialogFragment {

    //reference
    //https://www.youtube.com/watch?v=Bsm-BlXo2SI

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("World cases")
                .setMessage("Gain access to daily updates of the world total Covid-19 cases by clicking on the 'world total cases' button.")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
