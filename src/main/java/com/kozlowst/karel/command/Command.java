package com.kozlowst.karel.command;

import com.kozlowst.karel.world.World;

public interface Command<T> {
    void execute(T t, World world);
}
