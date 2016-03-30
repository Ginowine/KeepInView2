package com.tech.c3nx.keepinview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdulrahman on 3/30/2016.
 */
public class ProjectsAdapter extends BaseAdapter {
    private  Context mContext;

    public static   final List<String> getProjects() {
        List<String> strings = new ArrayList<>();
        strings.add("Construction of Presidential Hospital");
        return strings;
    }
    public static   final List<String> getAmount() {
        List<String> strings = new ArrayList<>();
        strings.add("800,000,000,000");
        return strings;
    }
    public static   final List<String> getLocation() {
        List<String> strings = new ArrayList<>();
        strings.add("Abuja");
        return strings;
    }
    public static   final List<String> getStatus() {
        List<String> strings = new ArrayList<>();
        strings.add("Ongoing");
        return strings;
    }

    public ProjectsAdapter (Context c) {
        mContext = c;
    }

    List<String> p_Names = getProjects();

    List<String> p_Amount = getAmount();

    List<String> p_Location = getLocation();

    List<String> p_Status = getStatus();

    @Override
    public int getCount() {
        return p_Names.size();
    }

    @Override
    public Object getItem(int position) {
        return p_Names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.project_layout, parent, false);
        }

        TextView p_id = (TextView) convertView.findViewById(R.id.p_id);
        p_id.setText(p_Names.indexOf(position));

        TextView p_Name = (TextView) convertView.findViewById(R.id.p_name);
        p_Name.setText(p_Names.get(position));

        TextView p_Amnt = (TextView) convertView.findViewById(R.id.p_amount);
        p_Amnt.setText(p_Amount.get(position));

        TextView p_statu = (TextView) convertView.findViewById(R.id.p_status);
        p_statu.setText(p_Status.get(position));

        TextView p_Loc = (TextView) convertView.findViewById(R.id.p_location);
        p_Loc.setText(p_Location.get(position));

        return convertView;
    }
}
