package com.example.bangit_emotilog.eventlog;

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


/**
 * EventLogAdapter creates the view holders for emoticon logs displayed in a recycler view.
 * The date format is used to format the event timestamps.
 */
public class EventLogAdapter extends RecyclerView.Adapter<EventLogAdapter.ViewHolder> {

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.log_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<EmoticonLog> events = LogRepository.getLogs();
        EmoticonLog event = events.get(position);
        holder.emotionColumn.setText(event.getEmoji());
        holder.timestampColumn.setText(dateTimeFormat.format(new Date(event.getTimestamp())));
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
