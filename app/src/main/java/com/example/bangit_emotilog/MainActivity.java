//Sources: https://www.geeksforgeeks.org/java/java-program-to-count-the-occurrence-of-each-character-in-a-string-using-hashmap/
//https://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity
//https://stackoverflow.com/questions/15686555/display-back-button-on-action-bar
package com.example.bangit_emotilog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button happyButton, sadButton, angryButton, tiredButton, shockedButton, celebrationButton, summaryButton;

    Button buttonViewLogs, buttonSummary;

    private void logEmoticon(String emoji){
        String timeStamp = java.text.DateFormat.getDateTimeInstance().format(new java.util.Date());

        EmoticonLog log = new EmoticonLog(emoji,timeStamp);

        LogRepository.addLog(log);

        android.widget.Toast.makeText(
                this,"Logged" + emoji + "at" + timeStamp, Toast.LENGTH_SHORT
        ).show();
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

        happyButton = findViewById(R.id.happyButton);
        sadButton = findViewById(R.id.sadButton);
        angryButton = findViewById(R.id.angryButton);
        tiredButton = findViewById(R.id.tiredButton);
        shockedButton = findViewById(R.id.shockedButton);
        celebrationButton = findViewById(R.id.celebrationButton);
        summaryButton = findViewById(R.id.summaryButton);

        happyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logEmoticon("\uD83D\uDE01");
            }
        });
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logEmoticon("\uD83D\uDE14");
            }
        });
        angryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                logEmoticon("\uD83D\uDE21");
            }
        });
        tiredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logEmoticon("😴");
            }
        });

        shockedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logEmoticon("😮");
            }
        });

        celebrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logEmoticon("🥳");
            }
        });
        summaryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SummaryScreen.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}