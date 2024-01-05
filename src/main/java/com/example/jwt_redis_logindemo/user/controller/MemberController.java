package com.example.jwt_redis_logindemo.user.controller;

import com.example.jwt_redis_logindemo.config.auth.PrinsipalDetails;
import com.example.jwt_redis_logindemo.user.dto.SingUpDto;
import com.example.jwt_redis_logindemo.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ejum
 * @fileName : UserController
 * @since : 12/5/23
 */
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {


    private final MemberService memberService;

//    Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IiIsImlhdCI6MTcwMjEwMTYzMSwiZXhwIjoxNzAyMTA1MjMxfQ.RLLFOGWYQVnQxdyQTTcEVcljCXe-mDP_HEWXZAPxL-A
//Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IiIsImlhdCI6MTcwMjEwMTY2MCwiZXhwIjoxNzAyMTA1MjYwfQ.bxu2LJJnWEUVL-_OCjT-I7HilL_z4f5MvTHg_awMXtw
//    Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6IiIsImlhdCI6MTcwMjEwMTY0MSwiZXhwIjoxNzAyMTA1MjQxfQ.3efhBV-QsbCzpu8d4FldSzHIgW7i_s-5M8entqWnVq8
//

    @GetMapping("/login")
    public String login(){
        return "forward:/login.jsp";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute SingUpDto singUpDto) {
        // 사용자 등록 로직 수행

        memberService.registerUser(singUpDto);
        return "redirect:/member/login";
    }

    @GetMapping("/check")
    public String getToken(@AuthenticationPrincipal PrinsipalDetails prinsipalDetails) {

        prinsipalDetails.getUsername();
        System.out.println("체크를 눌렀을때 ");

            return "사용자 인증 완료";
    }



    @GetMapping("/welcome")
    public String welcomePage(@AuthenticationPrincipal PrinsipalDetails prinsipalDetails, Model model) {
        model.addAttribute("username", prinsipalDetails.getUsername());
        model.addAttribute("userAuthorities",prinsipalDetails.getAuthorities());
        model.addAttribute("userpassword",prinsipalDetails.getPassword());
        model.addAttribute("userclass",prinsipalDetails.getClass());
        return "forward:/welcome.jsp";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "forward:/signup.jsp";
    }




}
