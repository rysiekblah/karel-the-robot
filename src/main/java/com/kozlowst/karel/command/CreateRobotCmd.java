package com.kozlowst.karel.command;

import com.kozlowst.karel.message.Direction;
import com.kozlowst.karel.world.World;

import java.awt.*;

public class CreateRobotCmd implements Command<Graphics2D> {

    private int street;
    private int avenue;
    private Direction direction;

    public CreateRobotCmd(int street, int avenue, Direction direction) {
        this.street = street;
        this.avenue = avenue;
        this.direction = direction;
    }

    @Override
    public void execute(Graphics2D graphics2D, World world) {

    }
}
