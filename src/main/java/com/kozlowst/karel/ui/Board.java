package com.kozlowst.karel.ui;

import com.kozlowst.karel.world.World;
import com.kozlowst.karel.command.Command;
import com.kozlowst.karel.executor.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Board extends JPanel implements CommandExecutor {

    private World world;
    private List<Command> commands = new ArrayList<>();

    @Autowired
    public Board(World world) {
        System.out.println("H: " + world.getHeigh() + ", W: " + world.getWidth());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(world.getWidth(), world.getHeigh()));
        setFocusable(true);
        this.world = world;
        this.world.setImageObserver(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Command command : commands) {
            command.execute(g, world);
        }

    }

    @Override
    public void publishCommand(Command command) {
        commands.add(command);
        revalidate();
        repaint();
    }
}
