package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAction {
    @RequestMapping("/q")
    public String a(){
        return "a";
    }
}
