package com.example.maccoffe;

import java.io.Serializable;

public class SandwichesMoudel implements Serializable {


    private String name;
    private int prize;
    public   int Quantity=0;
    private String imageUrl;



    public SandwichesMoudel(String name, int prize, String imageUrl) {
        this.name = name;
        this.prize = prize;
        this.imageUrl = imageUrl;

    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPrize() {
        return prize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "CoffeeMoudel{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", Quantity=" + Quantity +
                ", prize='" + prize + '\'' +
                '}';
    }

    public String toMessage(){

        String message="";
        message+="\n Name: "+getName();
        message+="\n Quantity"+Quantity;
        message+="\n ..........................";
        return message;
    }
}