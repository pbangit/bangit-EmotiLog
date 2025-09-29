package com.example.bangit_emotilog;

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

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    @Override
    public String toString(){
        return timeStamp + "-" + emoji;
    }
}
