package com.example.moneyconvert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] units;
    private int[] flags;

    public CustomSpinnerAdapter(Context context, String[] units, int[] flags) {
        super(context, android.R.layout.simple_spinner_item, units);
        this.context = context;
        this.units = units;
        this.flags = flags;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createItem(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createItem(position, convertView, parent);
    }

    private View createItem(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);

        ImageView img = view.findViewById(R.id.imgFlag);
        TextView txt = view.findViewById(R.id.txtUnit);

        img.setImageResource(flags[position]);
        txt.setText(units[position]);

        return view;
    }
}
