package com.example.busybee.ui.home;



//NOT REALLY USING THIS CLASS AT THE MOMENT



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.busybee.databinding.ActivityMainBinding;
import com.example.busybee.databinding.ListRowBinding;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter{

    ArrayList<TaskType> arrayList;
    Context context;
    // new:
    private ListRowBinding binding;     // the data binding library generates binding classes to access the xml layouts

    // ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

    public CustomAdapter(Context context, ArrayList<TaskType> arrayList) {
        super(context, 0, arrayList);
        this.arrayList=arrayList;
        this.context=context;
    }


    //return view displaying data at position
    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskType subjectData=arrayList.get(position);
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            LinearLayout rowLay = (LinearLayout) findViewById(R.id.list_row);

            // original:
            convertView=layoutInflater.inflate(R.id.rowlayout, null);

            TextView title=convertView.findViewById(R.id.title);
            title.setText(subjectData.getTaskName());
            //

            // trying new stuff right now

            binding = ListRowBinding.inflate(getLayoutInflater());  // inflate method creates an instance of the binding class for this activity to use
            setContentView(binding.getRoot());

        }
        return convertView;
    }
//*/


    // return view displaying data at position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskType subjectData=arrayList.get(position);

        if(convertView==null){
            // inflate list_row.xml
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            binding = ListRowBinding.inflate(layoutInflater);       // inflating xml file called list_row


            // find textview widget using binding
            TextView textView = binding.title;         // PREVIOUS CODE: TextView title=convertView.findViewById(R.id.title);
            textView.setText(subjectData.getTaskName());     // PREVIOUS CODE: title.setText(subjectData.getTaskName());

            return binding.getRoot();                               // we have to return a view
        }
        return convertView;
    }

}
