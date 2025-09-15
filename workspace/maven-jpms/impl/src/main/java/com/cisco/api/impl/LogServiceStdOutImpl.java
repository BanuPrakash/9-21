package com.cisco.api.impl;

import com.cisco.api.LogService;

public class LogServiceStdOutImpl implements LogService  {
    @Override
    public void info(String message) {
        System.out.println("Log Std " + message);
    }
}
