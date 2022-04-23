package com.edge.extension;

public class Holder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    void set(T value) {
        this.value = value;
    }
}
