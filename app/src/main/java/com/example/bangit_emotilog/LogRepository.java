package com.example.bangit_emotilog;

import java.util.ArrayList;
import java.util.List;

/**
 * LogRepository stores different events in an ordered list.
 * Currently only supports queries for the entire list. If more activities require filtering by a
 * date, like in SummaryActivity, then the function could be added into here.
 * Decided to limit LogRepository to returning entire list.
 */
public class LogRepository {
    private static List<EmoticonLog> logs = new ArrayList<>();
    public static void addLog(EmoticonLog log){
        logs.add(log);
    }
    public static List<EmoticonLog> getLogs(){
        return logs;
    }

    public static void clearLogs(){
        logs.clear();
    }
}
