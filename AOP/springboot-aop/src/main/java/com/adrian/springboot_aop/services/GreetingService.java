package com.adrian.springboot_aop.services;

public interface GreetingService {

    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);

}
