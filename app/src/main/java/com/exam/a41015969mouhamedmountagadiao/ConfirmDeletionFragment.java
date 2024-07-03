package com.exam.a41015969mouhamedmountagadiao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.function.Consumer;

public class ConfirmDeletionFragment extends DialogFragment {

  private final Consumer<Boolean> callback;

  public ConfirmDeletionFragment(Consumer<Boolean> callback) {
    this.callback = callback;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the Builder class for convenient dialog construction.
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setMessage("Supprimer ?")
        .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            callback.accept(true);
          }
        })
        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            callback.accept(false);
          }
        });
    // Create the AlertDialog object and return it.
    return builder.create();
  }
}
