package com.example.myapplication4;

public class ListBean {
    private String text;
    private int ImageID;

    public ListBean(String text, int imageID) {
        this.text = text;
        ImageID = imageID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}
