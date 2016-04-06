package com.homework.moibleapp.oscars;


public class Movies {
    private String name;
    private String image;


    public Movies(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageName) {
        this.image = image;
    }

}
