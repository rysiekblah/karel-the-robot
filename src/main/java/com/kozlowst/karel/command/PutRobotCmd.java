package com.kozlowst.karel.command;

import com.kozlowst.karel.world.World;

import java.awt.*;

public class PutRobotCmd implements Command<Graphics2D> {

    private int avenue;
    private int street;

    public PutRobotCmd(int avenue, int street) {
        this.avenue = avenue;
        this.street = street;
    }

    @Override
    public void execute(Graphics2D graphics2D, World world) {

        int h = world.getRobot().getHeight(world.getImageObserver());
        int w = world.getRobot().getWidth(world.getImageObserver());

        graphics2D.drawImage(
                world.getRobot(),
                world.getAvenueCoordinate(avenue) - w/2,
                world.getStreetCoordinate(street) - h/2,
                world.getImageObserver());
    }
}
