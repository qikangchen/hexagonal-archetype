package com.github.qikangchen.archetype.application.port.out;

public interface Lock {

    void lock(int id);

    void release(int id);

}
