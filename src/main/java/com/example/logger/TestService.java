package com.example.logger;

import org.springframework.stereotype.Service;


@Service
public class TestService{

    @ExecuteTaskAndLog
    public void doSomething() {
        System.out.println("류찬은 최고에요!!");
    }

    @ExecuteTaskAndLog
    public String doSting() {
        return "류찬은 최고에요!!";
    }

    @ExecuteTaskAndLog
    public int getRyoochanIQ() {
        return 200;
    }
}
