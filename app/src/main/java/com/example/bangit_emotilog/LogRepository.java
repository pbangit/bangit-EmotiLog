package com.example.bangit_emotilog;

import java.util.ArrayList;
import java.util.List;

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
