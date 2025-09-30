package com.example.bangit_emotilog.summary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangit_emotilog.EmoticonLog;
import com.example.bangit_emotilog.LogRepository;
import com.example.bangit_emotilog.R;
import com.example.bangit_emotilog.eventlog.EventLogAdapter;


import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.ViewHolder> {
    private Map<String, Integer> todayCounts;
    private Map<String, Integer> totalCounts;

    public SummaryAdapter(Map<String, Integer> todayCounts, Map<String, Integer> totalCounts) {
        this.todayCounts = todayCounts;
        this.totalCounts = totalCounts;
    }

    @NonNull
    @Override
    public SummaryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.summary_grid_row, parent, false);

        return new SummaryAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SummaryAdapter.ViewHolder holder, int position) {
        List<EmoticonLog> events = LogRepository.getLogs();
        // Display logs from latest to earliest
        // EmotionEvent event = events.get(events.size() - position - 1);
        // Display logs from earliest to latest
        List <String> keyList = new ArrayList<>(totalCounts.keySet());
        String key = keyList.get(position);
        holder.emojiColumn.setText(key);
        holder.frequencyColumn.setText(todayCounts.get(key).toString());
        holder.allTimeCountColumn.setText(totalCounts.get(key).toString());
    }

    @Override
    public int getItemCount() {
        return totalCounts.keySet().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView emojiColumn;
        TextView frequencyColumn;

        TextView allTimeCountColumn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emojiColumn = itemView.findViewById(R.id.emojiColumn);
            frequencyColumn = itemView.findViewById(R.id.frequencyColumn);
            allTimeCountColumn = itemView.findViewById(R.id.allTimeCountColumn);
        }
    }

}
