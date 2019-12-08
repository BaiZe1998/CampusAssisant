package com.android.assistant;

public class College {

    private String name;

    private int imageId;

    public College(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
