package com.example.json;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Pojo> listdata;

    public CustomAdapter(Activity activity, List<Pojo> listdata) {
        this.activity = activity;
        this.listdata = listdata;
    }



    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.listdata, null);

        TextView email = (TextView) convertView.findViewById(R.id.TxtEmail);
        TextView id = (TextView) convertView.findViewById(R.id.TxtId);

        Pojo pojo=listdata.get(position);
        email.setText(pojo.getEmail());
        id.setText(String.valueOf(pojo.getId()));

        return convertView;
    }
}
