package com.kozlowst.karel.message;

public class MessageDescriptor {
    private MessageType type;
    private Point location;
    private Direction direction;
    private String[] attributes;

    public MessageDescriptor(MessageType type) {
        this.type = type;
    }

    public MessageDescriptor(MessageType type, String[] attributes) {
        this(type);
        this.attributes = attributes;
    }

    public MessageDescriptor(MessageType type, int x, int y, Direction direction) {
        this(type, null);
        this.location = new Point(x, y);
        this.direction = direction;
    }

    public MessageType getType() {
        return type;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public Point getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }
}
