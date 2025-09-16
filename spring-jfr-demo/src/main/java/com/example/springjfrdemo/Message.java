package com.example.springjfrdemo;

import java.util.concurrent.atomic.AtomicLong;

public class Message {
    private static final AtomicLong counter = new AtomicLong();
    private final  long id;
    private final String message;

    public Message(String msg) {
        this.id = counter.incrementAndGet();
        this.message = msg;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
