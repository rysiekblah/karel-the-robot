package com.kozlowst.karel.world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

@Component
public class World {

    @Value("${karel.ui.width}")
    private int width;

    @Value("${karel.ui.heigh}")
    private int heigh;

    @Value("${karel.ui.granulation}")
    private int granulation;

    private int avenues;
    private int streets;

    private Image robot;
    private Image beeper;
    private ImageObserver imageObserver;


    public World() {
        robot = getImage("/images/Robot-icon64.png");
        beeper = getImage("/images/buzz128.png");
    }

    private Image getImage(String path) {
        return (new ImageIcon(this.getClass().getResource(path))).getImage();
    }

    public ImageObserver getImageObserver() {
        return imageObserver;
    }

    public void setImageObserver(ImageObserver imageObserver) {
        this.imageObserver = imageObserver;
    }

    public Image getRobot() {
        return robot;
    }

    public Image getBeeper() {
        return beeper;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigh() {
        return heigh;
    }

    public int getGranulation() {
        return granulation;
    }

    public int getAvenues() {
        return avenues;
    }

    public void setAvenues(int avenues) {
        this.avenues = avenues;
    }

    public int getStreets() {
        return streets;
    }

    public void setStreets(int streets) {
        this.streets = streets;
    }

    public int getAvenueStep() {
        return (getWidth() - getGranulation()) / (getAvenues() - 1);
    }

    public int getStreetStep() {
        return (getHeigh() - getGranulation()) / (getStreets() - 1);
    }

    public int getAvenueCoordinate(int avenueNum) {
        return getGranulation() / 2 + getAvenueStep() * (avenueNum - 1);
    }

    public int getStreetCoordinate(int streetNum) {
        return getGranulation() / 2 + getStreetStep() * (streets - streetNum);
    }
}
