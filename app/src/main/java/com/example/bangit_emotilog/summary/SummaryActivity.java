package com.example.bangit_emotilog.summary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangit_emotilog.logging.EmoticonEvent;
import com.example.bangit_emotilog.logging.LogRepository;
import com.example.bangit_emotilog.R;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * SummaryActivity is the class that displays the summary of today's events including the emoji frequency
 * and total count.
 * It queries the LogRepository for the list of events for the current date.
 *
 * Limitation: somewhat responsive if there are only a few emotions logged for the day.
 *
 * Resource:
 * https://www.geeksforgeeks.org/java/java-program-to-count-the-occurrence-of-each-character-in-a-string-using-hashmap/
 */
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
        Date currentDate = new Date();
        List<EmoticonEvent> logs = LogRepository.getLogs(currentDate);

        for (EmoticonEvent log : logs) {
            String emoji = log.getEmoji();
            todayCounts.put(emoji, todayCounts.getOrDefault(emoji, 0) + 1);
        }
        TextView totalCount = findViewById(R.id.totalCount);
        totalCount.setText(Integer.toString(logs.size()));

        SummaryAdapter adapter = new SummaryAdapter(todayCounts);
        recyclerView.setAdapter(adapter);

        Button backToMain = findViewById(R.id.summaryToHome);
        backToMain.setOnClickListener(v -> finish());
    }
}