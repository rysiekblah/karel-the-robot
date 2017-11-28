package com.kozlowst.karel.handler;

import com.kozlowst.karel.command.*;
import com.kozlowst.karel.executor.CommandExecutor;
import com.kozlowst.karel.message.MessageDescriptor;
import com.kozlowst.karel.message.Parser;
import com.kozlowst.karel.message.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler implements Handler {

    @Autowired
    private Parser<String> msgParser;
    @Autowired
    private CommandExecutor commandExecutor;

    @Override
    public void handleMessage(String message) {
        commandExecutor.publishCommand(createCommand(msgParser.processMessage(message)));
    }

    protected Command createCommand(MessageDescriptor messageDescriptor) {
        switch (messageDescriptor.getType()) {
            case World:
                return new CreateGameCmd(
                        messageDescriptor.getLocation().getX(),
                        messageDescriptor.getLocation().getY());
            case Wall:
                return new DrawWallCmd(
                        messageDescriptor.getLocation().getX(),
                        messageDescriptor.getLocation().getY(),
                        messageDescriptor.getDirection());
            case Robot:
                return new PutRobotCmd(
                        messageDescriptor.getLocation().getX(),
                        messageDescriptor.getLocation().getY());
            case Beeper:
                return new PutBeepersCmd(
                        messageDescriptor.getLocation().getX(),
                        messageDescriptor.getLocation().getY());
            case Turn:
                return new TurnCmd(Side.valueOf(messageDescriptor.getAttributes()[0]));
            case Move:
                return new MoveCmd();
            case Clear:
                return new ClearCmd();
            default:
                return null;
        }
    }

}
