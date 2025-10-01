package com.example.bangit_emotilog;

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
    private static List<EmoticonLog> logs = new ArrayList<>();
    public static void addLog(EmoticonLog log){
        logs.add(log);
    }
    public static List<EmoticonLog> getLogs(){
        return logs;
    }

    public static List<EmoticonLog> getLogs(Date date) {
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        List<EmoticonLog> logsOnDate = new ArrayList<>();
        String requestedDate = yearMonthDay.format(new Date());
        for (EmoticonLog log : getLogs()) {
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
