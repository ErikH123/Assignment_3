package com.example.assignment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Date> {
    private Context context;

    @Override
    public int getPosition(@Nullable Date item){
        return super.getPosition(item);
    }

    private ArrayList<Date> dataset;

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Date> objects){
        super(context, resource, objects);
        this.context = context;
        this.dataset = (ArrayList<Date>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View v = layoutInflater.inflate(R.layout.row_layout, parent, false);
        LinearLayout linearLayout = (LinearLayout) v;
        return linearLayout;
    }


}
