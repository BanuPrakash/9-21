package com.example.springjpmsdemo;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public void insertEmployee(Employee e) {
        System.out.println(e.getName() + " added!!");
    }
}
