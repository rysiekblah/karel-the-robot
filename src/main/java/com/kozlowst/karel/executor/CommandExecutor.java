package com.kozlowst.karel.executor;

import com.kozlowst.karel.command.Command;

public interface CommandExecutor {
    void publishCommand(Command command);
}
