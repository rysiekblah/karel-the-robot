package com.kozlowst.karel.message;

public enum Direction {
    North(1), East(2), South(3), West(4);

    private final int code;

    Direction(int code) {
        this.code = code;
    }

    public static Direction get(int code) {
        for (Direction direction : Direction.values()) {
            if (direction.code == code) return direction;
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
