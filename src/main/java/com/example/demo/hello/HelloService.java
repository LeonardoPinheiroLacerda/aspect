package com.example.demo.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @HelloAnnotation
    public void hello() {
        System.out.println("hello");
    }

}
