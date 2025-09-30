package com.example.bangit_emotilog;

/**
 * EmoticonLog represents a user's feeling at a specific date and time.
 * It only has getters because the emotion and time cannot change once logged.
 */
public class EmoticonLog {
    private String emoji;
    private String timeStamp;

    public EmoticonLog(String emoji, String timeStamp){
        this.emoji = emoji;
        this.timeStamp = timeStamp;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString(){
        return timeStamp + "-" + emoji;
    }
}
