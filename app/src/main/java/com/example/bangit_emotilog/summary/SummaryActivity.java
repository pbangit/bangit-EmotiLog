package com.example.bangit_emotilog.summary;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangit_emotilog.EmoticonLog;
import com.example.bangit_emotilog.LogRepository;
import com.example.bangit_emotilog.R;
import com.example.bangit_emotilog.eventlog.EventLogAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerView = findViewById(R.id.summaryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        Map<String, Integer> todayCounts = new LinkedHashMap<>();
        Map<String, Integer> totalCounts = new LinkedHashMap<>();
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        List<EmoticonLog> logs = LogRepository.getLogs();
        String today = yearMonthDay.format(new Date());
        for (EmoticonLog log : logs) {
            String logDate = yearMonthDay.format(new Date(log.getTimeStamp()));
            String emoji = log.getEmoji();
            if (logDate.equals(today) ) {
                todayCounts.put(emoji, todayCounts.getOrDefault(emoji, 0) + 1);
            }
            totalCounts.put(emoji, totalCounts.getOrDefault(emoji, 0) + 1);
        }

        SummaryAdapter adapter = new SummaryAdapter(todayCounts, totalCounts);
        recyclerView.setAdapter(adapter);

        Button backToMain = findViewById(R.id.summaryToHome);
        backToMain.setOnClickListener(v -> finish());
    }
}