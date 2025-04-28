package com.scaler.ecommerce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//localHost:8080/sample
@RequestMapping("/sample")

public class SampleController {
    //localHost:8080/sample/sayHello/raj
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "Hello " + name;
    }
    //localHost:8080/sample/sayBye
    @GetMapping("/sayBye")
    public String sayBye(){
        return "Bye all";
    }
}
