package com.example.bangit_emotilog.eventlog;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangit_emotilog.R;

/**
 * EventLogActivity is the class that displays the list of events with their timestamps.
 * It initializes a recyclerView with a grid layout manager.
 *
 * Resources used:
 * https://www.google.com/search?q=android+list+with+multiple+columns&sca_esv=6a2e7108dd344fc9&sxsrf=AE3TifON-wzgOKHQpmK63O-uipPP7G76gA%3A1759120179096&ei=MwvaaIHUBYHy0PEP39q42Ao&ved=0ahUKEwjBuZGrkf2PAxUBOTQIHV8tDqsQ4dUDCBA&uact=5&oq=android+list+with+multiple+columns&gs_lp=Egxnd3Mtd2l6LXNlcnAiImFuZHJvaWQgbGlzdCB3aXRoIG11bHRpcGxlIGNvbHVtbnMyCBAhGKABGMMEMggQIRigARjDBEjFGlC5CljsEXACeACQAQCYAYABoAHyBaoBAzIuNbgBA8gBAPgBAZgCCKACiQXCAgcQABiwAxgewgIOEAAYgAQYsAMYhgMYigXCAgsQABiwAxiiBBiJBcICCBAAGLADGO8FwgIGEAAYBxgewgIGEAAYBRgewgILEAAYgAQYhgMYigXCAgUQABjvBcICCBAAGIAEGKIEwgIKECEYoAEYwwQYCpgDAIgGAZAGBpIHAzQuNKAHjSSyBwMyLjS4B4YFwgcDMS43yAcN&sclient=gws-wiz-serp
 * https://www.google.com/search?q=android+list+with+multiple+columns
 * https://www.geeksforgeeks.org/android/recyclerview-using-gridlayoutmanager-in-android-with-example/
 */
public class EventLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_log);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.logRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        EventLogAdapter adapter = new EventLogAdapter();
        recyclerView.setAdapter(adapter);

        Button backToMain = findViewById(R.id.home);
        backToMain.setOnClickListener(v -> finish());

    }
}