package com.kozlowst.karel.handler;

import com.kozlowst.karel.command.*;
import com.kozlowst.karel.message.Direction;
import com.kozlowst.karel.message.MessageType;
import com.kozlowst.karel.message.Side;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandFactory {

    public Command createCommand(String message) {
        String[] tokens = message.trim().replaceAll("\\s+", " ").split(" ");
        MessageType type = MessageType.getByCode(tokens[0]);

        validateMessage(type, tokens.length);
        tokens = Arrays.copyOfRange(tokens, 1, tokens.length);

        switch (type) {
            case World:
                return new CreateGameCmd(
                        Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
            case Wall:

                return new DrawWallCmd(
                        Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), getDirection(tokens[2]));
            case Robot:
                return new PutRobotCmd(
                        Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
            case Beeper:
                return new PutBeepersCmd(
                        Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
            case Turn:
                return new TurnCmd(Side.valueOf(tokens[0]));
            case Move:
                return new MoveCmd();
            case Clear:
                return new ClearCmd();
            default:
                return null;
        }
    }

    protected void validateMessage(MessageType type, int tokensNum) {
        if (type == null)
            throw new IllegalArgumentException("Message format error. Type is missing.");

        if (type.getArgsNum() > tokensNum)
            throw new IllegalArgumentException("Some arguments missing. Usage: " + type.getUsage());
    }

    protected Direction getDirection(String token) {
        Direction direction = Direction.get(Integer.valueOf(token));
        if (direction == null) throw new IllegalArgumentException("Direction is missing");
        return direction;
    }

}
