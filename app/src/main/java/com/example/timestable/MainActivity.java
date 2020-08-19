package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView listView;
    TextView textView;
    int timesTable=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.timesTableSeekBar);
        listView = findViewById(R.id.timesTableListView);
        textView = findViewById(R.id.tableOf);
        seekBar.setMax(100);
        seekBar.setProgress(1);
        textView.setText("Table of "+timesTable);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;

                if (i < min) {
                    timesTable = min;
                    seekBar.setProgress(min);
                } else {
                    timesTable = i;
                }

                textView.setText("Table of "+ timesTable);
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(1);

    }

    public void generateTimesTable(int timesTableValue) {
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            timesTableContent.add(Integer.toString(i * timesTableValue));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        listView.setAdapter(arrayAdapter);

    }
}