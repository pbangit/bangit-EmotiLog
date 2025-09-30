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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.ViewHolder> {
    private static int TYPE_HEADER = 0;
    private static int TYPE_ITEM = 1;

    private Map<String, Integer> todayCounts;
    private Map<String, Integer> totalCounts;

    public SummaryAdapter(Map<String, Integer> todayCounts, Map<String, Integer> totalCounts) {
        this.todayCounts = todayCounts;
        this.totalCounts = totalCounts;
    }

    @NonNull
    @Override
    public SummaryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.summary_grid_header, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.summary_grid_row, parent, false);
        }

        return new SummaryAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SummaryAdapter.ViewHolder holder, int position) {
        if (position > 0) {
            List<String> keyList = new ArrayList<>(totalCounts.keySet());
            // Position 0 is the header when determining the type. But positions > 0 are
            // indexes into the keylist so they must be turned to zero-based indexes.
            String key = keyList.get(position - 1);
            holder.emojiColumn.setText(key);
            holder.frequencyColumn.setText(todayCounts.get(key).toString());
            holder.allTimeCountColumn.setText(totalCounts.get(key).toString());
        }
        // else position 0 is the header so there's nothing to bind
    }

    @Override
    public int getItemCount() {
        return totalCounts.keySet().size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? TYPE_HEADER : TYPE_ITEM;
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
