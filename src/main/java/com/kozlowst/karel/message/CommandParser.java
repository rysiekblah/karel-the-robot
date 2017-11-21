package com.kozlowst.karel.message;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandParser implements Parser<String> {
    @Override
    public MessageDescriptor processMessage(String s) throws IllegalArgumentException {
        String[] tokens = s.trim().replaceAll("\\s+", " ").split(" ");
        MessageType type = MessageType.getByCode(tokens[0]);
        return buildDescriptor(type, Arrays.copyOfRange(tokens, 1, tokens.length));
    }

    protected MessageDescriptor buildDescriptor(MessageType type, String[] tokens) {
        validateMessage(type, tokens.length);

        switch (type) {
            case World:
            case Beeper:
                return new MessageDescriptor(
                        type, Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), null);
            case Wall:
            case Robot:
                Direction direction = Direction.get(Integer.valueOf(tokens[2]));
                if (direction == null) throw new IllegalArgumentException("Direction is missing");
                return new MessageDescriptor(type, Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), direction);
            case Move:
            case Clear:
                return new MessageDescriptor(type);
            case Turn:
                return new MessageDescriptor(type, tokens);
            default:
                throw new IllegalArgumentException("Type is unknown");
        }

    }

    protected void validateMessage(MessageType type, int tokensNum) {
        if (type == null)
            throw new IllegalArgumentException("Message format error. Type is missing.");

        if (type.getArgsNum() > tokensNum)
            throw new IllegalArgumentException("Some arguments missing. Usage: " + type.getUsage());
    }
}
