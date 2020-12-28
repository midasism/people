package com.people.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/first/userlogin")
    public void userLogin(){

    }
}
