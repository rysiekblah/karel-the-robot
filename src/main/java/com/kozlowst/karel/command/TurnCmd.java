package com.kozlowst.karel.command;

import com.kozlowst.karel.message.Side;
import com.kozlowst.karel.world.World;

import java.awt.*;

public class TurnCmd implements Command<Graphics2D> {

    private Side side;

    public TurnCmd(Side side) {
        this.side = side;
    }

    @Override
    public void execute(Graphics2D graphics2D, World world) {

    }
}
