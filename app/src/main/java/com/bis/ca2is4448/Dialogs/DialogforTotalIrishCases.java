package com.bis.ca2is4448.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogforTotalIrishCases  extends AppCompatDialogFragment {

        //reference
        //https://www.youtube.com/watch?v=Bsm-BlXo2SI

        @NonNull
        @Override
        public Dialog onCreateDialog (@Nullable Bundle savedInstanceState){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("All irish cases")
                    .setMessage("click ont the 'all irish cases' button to view statistics on the daily Covid-19 cases in Ireland")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            return builder.create();
        }
    }



