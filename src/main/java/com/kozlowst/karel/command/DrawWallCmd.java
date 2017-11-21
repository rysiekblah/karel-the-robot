package com.kozlowst.karel.command;

import com.kozlowst.karel.world.World;
import com.kozlowst.karel.message.Direction;

import java.awt.*;

public class DrawWallCmd implements Command<Graphics2D> {

    private int x;
    private int y;
    private Direction direction;

    public DrawWallCmd(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void execute(Graphics2D graphics2D, World world) {

        graphics2D.setColor(Color.ORANGE);
        graphics2D.setStroke(new BasicStroke(6));

        switch (direction) {
            case North: graphics2D.drawLine(
                    world.getAvenueCoordinate(x) - world.getGranulation() / 2,
                    world.getStreetCoordinate(y) - world.getGranulation() / 2,
                    world.getAvenueCoordinate(x) + world.getGranulation() / 2,
                    world.getStreetCoordinate(y) - world.getGranulation() / 2);
                    break;

            case South: graphics2D.drawLine(
                    world.getAvenueCoordinate(x) - world.getGranulation() / 2,
                    world.getStreetCoordinate(y) + world.getGranulation() / 2,
                    world.getAvenueCoordinate(x) + world.getGranulation() / 2,
                    world.getStreetCoordinate(y) + world.getGranulation() / 2);
                break;
            case East: graphics2D.drawLine(
                    world.getAvenueCoordinate(x) + world.getGranulation() / 2,
                    world.getStreetCoordinate(y) - world.getGranulation() / 2,
                    world.getAvenueCoordinate(x) + world.getGranulation() / 2,
                    world.getStreetCoordinate(y) + world.getGranulation() / 2);
                break;

            case West: graphics2D.drawLine(
                    world.getAvenueCoordinate(x) - world.getGranulation() / 2,
                    world.getStreetCoordinate(y) - world.getGranulation() / 2,
                    world.getAvenueCoordinate(x) - world.getGranulation() / 2,
                    world.getStreetCoordinate(y) + world.getGranulation() / 2);
                break;
        }
    }
}
