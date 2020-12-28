package com.people.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/404")
    public String notFound(){
        return "404";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/forget")
    public String forget(){
        return "forget";
    }

    @GetMapping("/information_update")
    public String information_update(){
        return "information_update";
    }

    @GetMapping("/password_update")
    public String password_update(){
        return "password_update";
    }

    @GetMapping("/checkwork")
    public String CheckWork(){
        return "CheckWork";
    }

    @GetMapping("/punchIn")
    public String punchIn(){
        return "punchIn";
    }

    @GetMapping("/punchOut")
    public String punchOut(){
        return "punchOut";
    }

    @GetMapping("/induction")
    public String induction(){
        return "induction";
    }

    @GetMapping("/outduction")
    public String outduction(){
        return "outduction";
    }

    @GetMapping("/salary")
    public String salary(){
        return "salary";
    }

    @GetMapping("/countTable")
    public String countTable(){
        return "countTable";
    }

    @GetMapping("/employee")
    public String employee(){
        return "employee";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
