//Sources: https://www.geeksforgeeks.org/java/java-program-to-count-the-occurrence-of-each-character-in-a-string-using-hashmap/
//https://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity
package com.example.bangit_emotilog;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bangit_emotilog.eventlog.EventLogActivity;
import com.example.bangit_emotilog.summary.SummaryActivity;

public class MainActivity extends AppCompatActivity {
    Button happyButton, sadButton, angryButton, tiredButton, shockedButton, celebrationButton, summaryButton, viewLogButton;

    Button buttonViewLogs, buttonSummary;

    private void logEmoticon(String emoji){
        String timeStamp = java.text.DateFormat.getDateTimeInstance().format(new java.util.Date());

        EmoticonLog log = new EmoticonLog(emoji,timeStamp);

        LogRepository.addLog(log);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        summaryButton = findViewById(R.id.summaryButton);
        viewLogButton = findViewById(R.id.viewLogButton);

        //https://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity
        summaryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SummaryActivity.class));
            }
        });
        viewLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EventLogActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}