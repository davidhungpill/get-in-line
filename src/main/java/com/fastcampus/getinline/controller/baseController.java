package com.fastcampus.getinline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class baseController {

    @GetMapping("/")
    public String root() throws Exception {
        //throw new Exception("테스트");
        return "index";
    }


}
