package com.software.digimonhunter.Digimon;

import java.io.Serializable;

public class DigimonModel implements Serializable {

    public String DigimonName;
    public String DigimonNumber;public String DigimonDesc;
    public String Price;
    public int ImageDrawer;

    public String getDigimonName() {
        return DigimonName;
    }

    public void setDigimonName(String digimonName) {
        DigimonName = digimonName;
    }

    public String getDigimonNumber() {
        return DigimonNumber;
    }

    public void setDigimonNumber(String digimonNumber) {
        DigimonNumber = digimonNumber;
    }

    public String getDigimonDesc() {
        return DigimonDesc;
    }

    public void setDigimonDesc(String digimonDesc) {
        DigimonDesc = digimonDesc;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getImageDrawer() {
        return ImageDrawer;
    }

    public void setImageDrawer(int imageDrawer) {
        ImageDrawer = imageDrawer;
    }

}
