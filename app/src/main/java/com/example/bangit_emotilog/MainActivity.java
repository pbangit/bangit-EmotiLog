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

import com.example.bangit_emotilog.EmoticonLog;
import com.example.bangit_emotilog.LogRepository;
import com.example.bangit_emotilog.eventlog.EventLogActivity;
import com.example.bangit_emotilog.summary.SummaryActivity;

/**
 * MainActivity is the starting screen of the app with emoticon buttons and buttons to get to other
 * activities (like summary and logs).
 * It uses the EmoticonButton to log emotion events.
 *
 * Resources:
 * https://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity
 */
public class MainActivity extends AppCompatActivity {

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

        Button summaryButton = findViewById(R.id.summaryButton);
        Button viewLogButton = findViewById(R.id.viewLogButton);

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