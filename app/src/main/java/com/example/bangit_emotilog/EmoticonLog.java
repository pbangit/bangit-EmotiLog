package com.example.bangit_emotilog;

/**
 * EmoticonLog represents a user's feeling at a specific date and time.
 * It only has getters because the emotion and time cannot change once logged.
 */
public class EmoticonLog {
    private String emoji;
    private String timestamp;

    public EmoticonLog(String emoji, String timestamp){
        this.emoji = emoji;
        this.timestamp = timestamp;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString(){
        return timestamp + "-" + emoji;
    }
}
