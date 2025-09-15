package com.example.springjpmsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpmsDemoApplication {

    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(SpringJpmsDemoApplication.class, args);
        EmployeeService service = context.getBean("employeeService", EmployeeService.class);
        service.insertEmployee(Employee.builder().name("Roger").build());
    }

}
