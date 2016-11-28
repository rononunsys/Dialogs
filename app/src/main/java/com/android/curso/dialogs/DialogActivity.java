package com.android.curso.dialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button buttonSelection = (Button) findViewById(R.id.selectionDialog);
        Button buttonSelectionRadio = (Button) findViewById(R.id.selectionRadioDialog);
        Button buttonSelectionCheck = (Button) findViewById(R.id.selectionCheckDialog);

        final String[] items = {"Español", "Inglés", "Francés"};
        final boolean[] answers = {false, false, false};

        buttonSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("Selección")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {
                                Log.i("Dialogos","Opción elegida: "+ items[position]);
                            }
                        });
                builder.create().show();
            }
        });

        buttonSelectionRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("Selección")
                        .setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position) {
                                Log.i("Dialogos","Opción elegida: "+ items[position]);
                            }
                        });
                builder.create().show();
            }
        });

        buttonSelectionCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle("Selección")
                        .setMultiChoiceItems(items,answers ,new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position, boolean b) {
                                Log.i("Dialogos","Opción elegida: "+ items[position]);
                            }
                        });
                builder.create().show();
            }
        });
    }
}
