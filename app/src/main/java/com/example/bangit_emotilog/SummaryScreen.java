package com.example.bangit_emotilog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.List;
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

        Map<String, Integer> counts = new LinkedHashMap<>();
        for(EmoticonLog log : logs) {
            String emoji = log.getEmoji();
            if (!counts.containsKey(emoji)) {
                counts.put(emoji, 0);
            }
            counts.put(emoji,counts.get(emoji) + 1);
        }
        String[] summaryItems = new String[counts.size()];
        int i = 0;
        for(Map.Entry<String, Integer> entry : counts.entrySet()){
            summaryItems[i++] = entry.getKey() + "-->" + entry.getValue();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,summaryItems
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
