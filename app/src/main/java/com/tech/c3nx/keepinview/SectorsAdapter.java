package com.tech.c3nx.keepinview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import android.app.Activity;

/**
 * Created by Abdulrahman on 3/29/2016.
 */
public class SectorsAdapter  extends BaseAdapter{
    private  Context mContext;

    public static   final List<String> getStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("AGRICULTURE");
        strings.add("AUDITOR GENERAL");
        strings.add("BUDGET AND NATIONAL PLANNING");
        strings.add("CODE OF CONDUCT BUREAU");
        strings.add("COMMUNICATION TECHNOLOGY");
        strings.add("DEFENCE");
        strings.add("EDUCATION");
        strings.add("FEDERAL CHARACTER COMMISSION");
        strings.add("FINANCE");
        strings.add("FISCAL RESPONSIBILITY COMMISSION");
        strings.add("FOREIGN AFFAIRS");
        strings.add("HEAD OF CIVIL SERVICE");
        strings.add("HEALTH");
        strings.add("ICPC");
        strings.add("INDUSTRY TRADE AND INVESTMENT");
        strings.add("INFORMATION AND CULTURE");
        strings.add("INFRASTRUCTURE CONCESSIONARY REGULATORY COMMISSION");
        strings.add("INTERIOR");
        strings.add("JUSTICE");
        strings.add("LABOUR AND EMPLOYMENT");
        strings.add("NATIONAL ASSEMBLY");
        strings.add("NATIONAL POPULATION COMMISSION");
        strings.add("NATIONAL SALARIES INCOME AND WAGES COMMISSION");
        strings.add("NATIONAL SECURITY ADVISER");
        strings.add("NIGER DELTA");
        strings.add("PETROLEUM");
        strings.add("POLICE SERVICE COMMISSION");
        strings.add("PRESIDENCY");
        strings.add("REVENUE MOBILISATION ");
        strings.add("SCIENCE AND TECHNOLOGY");
        strings.add("SECRETARY TO THE GOVERNMENT OF THE FEDERATION");
        strings.add("SOLID MINERALS");
        strings.add("SPECIAL DUTIES SGF");
        strings.add("TRANSPORTATION");
        strings.add("WATER RESOURCES");
        strings.add("WOMEN AFFAIRS");
        strings.add("WORKS POWER AND HOUSING");
        strings.add("YOUTH AND SPORT DEVELOPMENT");

        return strings;
    }

    public SectorsAdapter(Context c) {
        mContext = c;
    }


    List<String> secNames = getStrings();


    @Override
    public int getCount() {
        return secNames.size();
    }

    @Override
    public Object getItem(int position) {
        return secNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.proposal_view, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.sec_image);

        TextView textView = (TextView) convertView.findViewById(R.id.sec_name);
        textView.setText(secNames.get(position));

        return convertView;
    }



}
