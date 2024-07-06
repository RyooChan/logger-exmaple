package com.example.logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void testLogFirst() {
        testService.doSomething();
    }

    @Test
    public void testLogSecond() {
        System.out.println(testService.doSting());
    }

    @Test
    public void testLogThird() {
        System.out.println(testService.getRyoochanIQ());
    }
}