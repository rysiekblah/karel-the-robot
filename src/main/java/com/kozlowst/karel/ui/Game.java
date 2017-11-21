package com.kozlowst.karel.ui;

import com.kozlowst.karel.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

@Component
public class Game extends JFrame {

    private Handler handler;

    @Value("${karel.ui.width}")
    public String width;

    @Autowired
    public Game(Handler handler, Board board) {
        add(board);
        this.handler = handler;

        setResizable(false);
        pack();

        setTitle("Karel the Robot");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/context.xml");

        Game game = ctx.getBean(Game.class);
        EventQueue.invokeLater(() -> {
            JFrame ex = game;
            ex.setVisible(true);
        });

        System.out.println("APP is running!");
        System.out.println(" >>> " + game.width);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wait for command");
            String cmd = scanner.nextLine();
            System.out.println("Command: " + cmd);
            game.handler.handleMessage(cmd);
        }
    }
}
