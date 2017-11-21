package com.kozlowst.karel.message;

public enum MessageType {
    World("-G", 2, "-G streets avenues eg: -G 4 5"),
    Wall("-W", 3, "-W street avenue direction eg: -W 2 4 1"),
    Beeper("-B", 3, "-B street avenue numOfBeepers eg: -B 2 3 4"),
    Robot("-R", 3, "-R street avenue direction"),
    Turn("-T", 1, "-T side (L or R)"),
    Move("-M", 0, "-M"),
    Clear("-C", 0, "clears the screan");

    private final String code;
    private final int argsNum;
    private final String usage;

    MessageType(String code, int argsNum, String usage) {
        this.code = code;
        this.argsNum = argsNum;
        this.usage = usage;
    }

    public String getCode() {
        return code;
    }

    public int getArgsNum() {
        return argsNum;
    }

    public String getUsage() {
        return usage;
    }

    public static MessageType getByCode(String code) {
        for (MessageType messageType : MessageType.values()) {
            if (messageType.code.equals(code)) return messageType;
        }
        return null;
    }

}
