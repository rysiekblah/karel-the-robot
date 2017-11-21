package com.kozlowst.karel.command;

import com.kozlowst.karel.world.World;

import java.awt.*;

public class ClearCmd implements Command<Graphics2D> {
    @Override
    public void execute(Graphics2D graphics2D, World world) {
        graphics2D.clearRect(0, 0, world.getWidth(), world.getHeigh());
    }
}
