package com.kozlowst.karel.message;


public interface Parser<T> {
    MessageDescriptor processMessage(T t) throws IllegalArgumentException;
}
