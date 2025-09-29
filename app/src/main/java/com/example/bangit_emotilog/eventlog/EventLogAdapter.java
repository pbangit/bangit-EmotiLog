package com.example.bangit_emotilog.eventlog;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangit_emotilog.EmoticonLog;
import com.example.bangit_emotilog.LogRepository;
import com.example.bangit_emotilog.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EventLogAdapter extends RecyclerView.Adapter<EventLogAdapter.ViewHolder> {

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
    private Resources resources;
    private String packageName;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.log_grid, parent, false);
        resources = view.getContext().getResources();
        packageName = view.getContext().getPackageName();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<EmoticonLog> events = LogRepository.getLogs();
        // Display logs from latest to earliest
        // EmotionEvent event = events.get(events.size() - position - 1);
        // Display logs from earliest to latest
        EmoticonLog event = events.get(position);
        holder.emotionColumn.setText(event.getEmoji());
        holder.timestampColumn.setText(dateTimeFormat.format(new Date(event.getTimeStamp())));
    }

    @Override
    public int getItemCount() {
        return LogRepository.getLogs().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView emotionColumn;
        TextView timestampColumn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emotionColumn = itemView.findViewById(R.id.emotionColumn);
            timestampColumn = itemView.findViewById(R.id.timestampColumn);
        }
    }
}
