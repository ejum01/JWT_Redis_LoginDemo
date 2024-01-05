package com.example.jwt_redis_logindemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : ejum
 * @fileName : HomeController
 * @since : 12/9/23
 */
@Controller
public class HomeController {


    @GetMapping("/")//zzasdsad
    public String index() {
        return "forward:/index.jsp";
    }






}
