package com.example.bangit_emotilog;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EventLogScreen extends AppCompatActivity {
    ListView listViewLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_log_screen);

        listViewLogs = findViewById(R.id.listViewLogs);
        Button backToMain = findViewById(R.id.backToMain);

        List<EmoticonLog> logs = LogRepository.getLogs();
        List<String> logItems = new ArrayList<>();
        for (EmoticonLog log : logs) {
            logItems.add(log.getEmoji() + "at" + log.getTimeStamp());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logItems);
        listViewLogs.setAdapter(adapter);

        backToMain.setOnClickListener(v -> finish());
    }
}


