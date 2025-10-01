package com.example.bangit_emotilog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

/**
 * EmoticonLogButton is an extension of AppCompatButton, it automatically logs button click events
 * as emotion events. The emotion logged is assumed to be the text associated with the button.
 * This makes adding/changing emotion logging buttons simpler.
 *
 * Resources:
 * https://stackoverflow.com/questions/69930651/how-to-extend-the-button-class-in-android
 * https://www.google.com/search?q=error+inflating+custom+button+android&oq=error+inflating+custom+button+android&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRifBTIHCAQQIRifBTIHCAUQIRifBTIHCAYQIRifBTIHCAcQIRifBTIHCAgQIRifBTIHCAkQIRifBdIBCDgxMTdqMGo5qAIAsAIB&sourceid=chrome&ie=UTF-8
 * https://www.google.com/search?q=android+appcompatbutton+styles&sca_esv=fe0ebb4ec3b321c8&sxsrf=AE3TifNS_HRcOQtuB-bzOPOmEFID0-wfww%3A1759253711740&ei=zxTcaP34LNSe0PEP3uOT-AY&ved=0ahUKEwi9nLvkgoGQAxVUDzQIHd7xBG8Q4dUDCBA&uact=5&oq=android+appcompatbutton+styles&gs_lp=Egxnd3Mtd2l6LXNlcnAiHmFuZHJvaWQgYXBwY29tcGF0YnV0dG9uIHN0eWxlczIFECEYoAEyBRAhGKABMgUQIRifBTIFECEYnwVIhmhQpiFY7mVwA3gAkAEAmAHDAaAB3ReqAQUxOC4xMrgBA8gBAPgBAZgCIaACyRjCAg4QABiABBiwAxiGAxiKBcICCBAAGLADGO8FwgILEAAYsAMYogQYiQXCAgQQIxgnwgIOEAAYgAQYsQMYgwEYigXCAhEQLhiABBixAxjRAxiDARjHAcICDhAuGIAEGLEDGNEDGMcBwgILEAAYgAQYkQIYigXCAgoQABiABBhDGIoFwgIFEAAYgATCAggQLhiABBixA8ICDRAuGIAEGEMY5QQYigXCAg0QABiABBixAxhDGIoFwgIKEAAYgAQYFBiHAsICDRAAGIAEGLEDGBQYhwLCAgsQLhiABBixAxiDAcICCBAAGIAEGLEDwgIKECMYgAQYJxiKBcICBxAAGIAEGArCAgsQABiABBiGAxiKBcICBhAAGBYYHsICBxAAGIAEGA3CAgYQABgNGB7CAgUQABjvBZgDAIgGAZAGBpIHBTIxLjEyoAe24wGyBwUxOC4xMrgHxBjCBwczLjE5LjExyAdN&sclient=gws-wiz-serp
 */
public class EmoticonLogButton extends AppCompatButton {
    protected String emoji;

    private void logEmoticon(){
        String timestamp = java.text.DateFormat.getDateTimeInstance().format(new java.util.Date());

        EmoticonEvent log = new EmoticonEvent(emoji, timestamp);

        LogRepository.add(log);
    }

    private void initialize() {
        emoji = getText().toString();
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logEmoticon();
            }
        });
    }

    public EmoticonLogButton(Context context) {
        super(context);
        initialize();
    }

    public EmoticonLogButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public EmoticonLogButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }
}
