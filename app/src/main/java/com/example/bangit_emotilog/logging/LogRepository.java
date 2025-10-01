package com.example.bangit_emotilog.logging;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * LogRepository stores different events in an ordered list. It allows queries for all events
 * or only events on a given date.
 */
public class LogRepository {
    private static List<EmoticonEvent> logs = new ArrayList<>();
    public static void add(EmoticonEvent event){
        logs.add(event);
    }
    public static List<EmoticonEvent> getLogs(){
        return logs;
    }

    public static List<EmoticonEvent> getLogs(Date date) {
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        List<EmoticonEvent> logsOnDate = new ArrayList<>();
        String requestedDate = yearMonthDay.format(new Date());
        for (EmoticonEvent log : getLogs()) {
            String logDate = yearMonthDay.format(new Date(log.getTimestamp()));
            if (logDate.equals(requestedDate) ) {
                logsOnDate.add(log);
            }
        }
        return logsOnDate;
    }

    public static void clearLogs(){
        logs.clear();
    }
}
