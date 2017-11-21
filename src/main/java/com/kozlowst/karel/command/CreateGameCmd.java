package com.kozlowst.karel.command;

import com.kozlowst.karel.world.World;

import java.awt.*;

public class CreateGameCmd implements Command<Graphics2D> {

    private int numStreets;
    private int numAvenues;

    public CreateGameCmd(int numStreets, int numAvenues) {
        this.numStreets = numStreets;
        this.numAvenues = numAvenues;
    }

    @Override
    public void execute(Graphics2D graphics2D, World world) {
        // Stage-2
        world.setAvenues(numAvenues);
        world.setStreets(numStreets);

        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.setStroke(new BasicStroke(3));

        if (numAvenues == 1) {
            graphics2D.drawLine(world.getWidth()/2,0,world.getWidth()/2,world.getHeigh());
        } else {
            int avStep = (world.getHeigh() - world.getGranulation()) / (numAvenues - 1);
            for (int i = 0; i < numAvenues; i++) {
                graphics2D.drawLine(
                        world.getGranulation()/2 + avStep * i,
                        0,
                        world.getGranulation()/2 + avStep * i,
                        world.getHeigh());
            }
        }

        if (numStreets == 1) {
            graphics2D.drawLine(0, world.getHeigh()/2, world.getWidth(), world.getHeigh()/2);
        } else {
            int stStep = (world.getWidth() - world.getGranulation()) / (numStreets - 1);
            for (int i = 0; i < numStreets; i++) {
                graphics2D.drawLine(
                        0,
                        world.getGranulation()/2 + stStep * i,
                        world.getWidth(),
                        world.getGranulation()/2 + stStep * i);
            }
        }

    }

}
