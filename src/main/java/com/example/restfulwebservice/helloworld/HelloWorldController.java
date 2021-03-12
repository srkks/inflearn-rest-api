package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "helloWorld!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        /* 자바 빈 형태로 반환하게 되면 스프링프레임워크에서는
         *  json형태로 변환해서 반환하게 된다.
         *  이 경우, {message:"Hello World"}로 반환되게 된다.*/
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean hellowWorldBean(@PathVariable String name) {
        /* format메소드에서 %s는 가변 데이터가 들어갈 자리, 콤마 뒤에 오는 변수가 들어가게 된다.*/
        return new HelloWorldBean(String.format("Hello World! %s", name));
    }
}
