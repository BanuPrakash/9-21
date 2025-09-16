package com.example.springjfrdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping("/hello")
    public Message hello() {
        return new Message("hello");
    }


    @RequestMapping("/hello1")
    public Message hello1() {
        cpuIntensive();
        return new Message("hello1");
    }

    @RequestMapping("/hello2")
    public Message hello2() {
        gcIntensive();
        return new Message("hello2");
    }

    @RequestMapping("/hello3")
    public Message hello3() {
        lockContention();
        return new Message("hello3");
    }

    public  long number;
    private void cpuIntensive() {
        for(long i = 0; i < 100_000_000; i++) {
            number += i;
        }
    }

    Object value;
    private void  gcIntensive() {
        for(int i = 0; i < 1000; i++) {
            value= new Object[1024*1024];
        }
    }

    public Object lock = new Object();

    public void lockContention() {
        synchronized (lock) {
            try {
                lock.wait(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
