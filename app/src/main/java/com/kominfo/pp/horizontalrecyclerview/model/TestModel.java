package com.kominfo.pp.horizontalrecyclerview.model;

import java.io.Serializable;

public class TestModel implements Serializable {
    int img;
    String title;

    public TestModel(){

    }

    public TestModel(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
