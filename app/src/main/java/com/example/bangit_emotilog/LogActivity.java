package com.example.bangit_emotilog;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class LogActivity  extends AppCompatActivity {
    ListView listViewLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        listViewLogs = findViewById(R.id.listViewLogs);
    }
}
