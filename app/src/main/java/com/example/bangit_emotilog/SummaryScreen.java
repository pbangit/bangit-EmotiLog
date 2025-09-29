package com.example.bangit_emotilog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SummaryScreen extends AppCompatActivity {
    ListView listViewSummary;
    Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_screen);

        listViewSummary = findViewById(R.id.listViewSummary);
        backToMain = findViewById(R.id.backToMain);

        List<EmoticonLog> logs = LogRepository.getLogs();
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String today = yearMonthDay.format(new Date());

        Map<String, Integer> todayCounts = new LinkedHashMap<>();
        int totalAllTime = logs.size();
        for (EmoticonLog log : logs) {
            String logDate = yearMonthDay.format(new Date(log.getTimeStamp()));
            if (logDate.equals(today) ) {
                String emoji = log.getEmoji();
                todayCounts.put(emoji, todayCounts.getOrDefault(emoji, 0) + 1);
            }
        }


        List<String> summaryItems = new ArrayList<>();
        summaryItems.add("Today's count: ");
        for (Map.Entry<String, Integer> entry : todayCounts.entrySet()) {
            summaryItems.add(entry.getKey() + " logged today --> " + entry.getValue());
        }

        summaryItems.add("Total logs (all time) --> " + totalAllTime);

        Map<String, Integer> totalCounts = new LinkedHashMap<>();
        for(EmoticonLog log : logs) {
            String emoji = log.getEmoji();
            totalCounts.put(emoji, totalCounts.getOrDefault(emoji, 0) + 1);
        }
        summaryItems.add("");
        summaryItems.add("All time counts per emoji: ");
        for(Map.Entry<String, Integer> entry : totalCounts.entrySet()){
            summaryItems.add(entry.getKey() + "total --> " + entry.getValue());
        }



        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                summaryItems
        );
        listViewSummary.setAdapter(adapter);

        backToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
