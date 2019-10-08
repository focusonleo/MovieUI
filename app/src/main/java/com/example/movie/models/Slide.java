package com.example.movie.models;

public class Slide {

    //create fields for class Slide
    private int Image;
    private String Title;
    //Add more fields depending on what you want ....

    //to the constructor
    public Slide(int image, String title){
        Image = image;
        Title = title;
    }

    //getter of the field
    public int getImage(){
        return Image;
    }

    public String getTitle(){
        return Title;
    }

    //setter of the field
    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title){
        Title = title;
    }
}
