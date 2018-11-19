package com.example.michael.chatting.Model;

/**
 * A Structured class for messages.
 */
public class MessageModel {
    private String mName;
    private String mText;

    public MessageModel(String name, String text) {
        mName = name;
        mText = text;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }
}
