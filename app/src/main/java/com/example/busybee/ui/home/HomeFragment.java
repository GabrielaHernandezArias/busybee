package com.example.busybee.ui.home;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.support.v7.app.AppCompatActivity;


import com.example.busybee.R;
import com.example.busybee.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    private HomeViewModel homeViewModel;   // a new instance of the HomeViewModel class
    private FragmentHomeBinding binding;
    public ArrayList<TaskType> arrayList;   // we will store spinner items in an arraylist . spinner items are of type task type
    // variables for timer
    Button buttonTime;
    TextView textViewTime;
    public int counter;
    // variable for name
    Button buttonName;

    // 1. ON CREATE
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
         2. WIDGET: text view
         we grab the TextView widget from fragment_home.xml
         then we set its text (.setText) to string s
         */
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        /*
        3. WIDGET: spinner
        populating spinner with user choices
        to do this, we'll use a spinner adapter AND a listener
         */
        // find spinner widget
        Spinner spinnerTasks = (Spinner) binding.tasksSpinner;   // equivalent to findViewById(R.id.timer_tasks_spinner) ?
        // attach listener to spinner

        /* DAY LAST
        spinnerTasks.setOnItemSelectedListener(());

        // array adapter
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(getContext(), R.array.tasks_for_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTasks.setAdapter(adapter);  // attaching adapter to dropdown menu (spinner)


        //create array list and add data
        //  - need to update this to let users add options AND edit drawables
        arrayList = new ArrayList<TaskType>();
        arrayList.add(new TaskType("Math homework", 3, 12));
        arrayList.add(new TaskType("Math study", 2, 11));
        arrayList.add(new TaskType("LIT readings", 4, 4));
        arrayList.add(new TaskType("Philosophy readings", 2, 3));
        arrayList.add(new TaskType("Yoga", 4, 10));
        arrayList.add(new TaskType("Exercise", 1, 9));

        //CustomAdapter customAdapter = new CustomAdapter(getActivity(), arrayList);
        //spinnerTasks.setAdapter(customAdapter);
        // MAY 6
        */


        // WIDGETS: button to start timer
        buttonTime = (Button) binding.buttonTime;
        textViewTime = (TextView) binding.textviewTime;

        buttonTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        textViewTime.setText(String.valueOf(counter));
                        counter++;
                    }
                    public void onFinish(){
                        textView.setText("Timer finished!!");
                    }
                }.start();
            }
        });

        // WIDGETS: button for name 
        buttonName = (Button) binding.submitName;
        

        //
        return root;
    }

    // 4. method: ON DESTROY
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*
    // 5. CURSOR CLASS we will use for spinner
    public Cursor getCursor() {
        Cursor c = database.rawQuery("select * from " + Database.mylist + " where isCancel = 0", null);
        return c;
    }

     */

    // 6. METHOD: ON ITEM CLICK (FROM SPINNER) EDIT ALL though
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        // this past code is to open a website link: but what we want is to start timer and keep track of
        //String link = arrayList.get(position).getLink();
        //implicit intent to open link in browser
        //Uri uri = Uri.parse(link);
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);
    }

}