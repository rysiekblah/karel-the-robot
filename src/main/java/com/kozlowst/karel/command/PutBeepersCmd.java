package com.kozlowst.karel.command;

import com.kozlowst.karel.world.World;

import java.awt.*;

public class PutBeepersCmd implements Command<Graphics2D> {

    private int avenue;
    private int street;

    public PutBeepersCmd(int avenue, int street) {
        this.avenue = avenue;
        this.street = street;
    }

    @Override
    public void execute(Graphics2D graphics2D, World world) {
        int h = world.getBeeper().getHeight(world.getImageObserver());
        int w = world.getBeeper().getWidth(world.getImageObserver());

        graphics2D.drawImage(
                world.getBeeper(),
                world.getAvenueCoordinate(avenue) - w/2,
                world.getStreetCoordinate(street) - h/2,
                world.getImageObserver());
    }
}
