package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button buttonPoista;
    ListView listView1;
    ArrayList<Date> list;
    MyAdapter arrayAdapter;
    SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        arrayAdapter = new MyAdapter(this, R.layout.row_layout, list);

        button1 = findViewById(R.id.button1);
        buttonPoista = findViewById(R.id.buttonPoista);
        listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(arrayAdapter);

        final Date date = new Date();
        sdf = new SimpleDateFormat("HH:mm:ss");


        Context context = this;
        AlertDialog.Builder bd = new AlertDialog.Builder(context);
        bd.setMessage("Haluatko lisätä ajan listaan?");
        bd.setCancelable(true);

        bd.setPositiveButton(
                "Kyllä",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.add(date);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
        bd.setNegativeButton(
                "Ei",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = bd.create();


        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });

    }
}
