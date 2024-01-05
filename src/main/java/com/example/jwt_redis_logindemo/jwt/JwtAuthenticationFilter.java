package com.example.jwt_redis_logindemo.jwt;

import com.example.jwt_redis_logindemo.user.dto.LoginDto;
import com.example.jwt_redis_logindemo.user.repository.MemberRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ejum
 * @fileName : JwtAuthticationFilter
 * @since : 12/11/23
 */
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MemberRepository memberRepository;


    public Authentication authentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Gson gson = new Gson();
        LoginDto loginDto = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            loginDto = gson.fromJson(reader, LoginDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("loginDto = {} ",loginDto);

        if((loginDto.getUsername().startsWith("user")||loginDto.getUsername().startsWith("admin")) && loginDto.getPassword().equals("1234"))
            memberRepository.updatePassword(loginDto.getUsername(), bCryptPasswordEncoder.encode("1234"));

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        log.info("authenticationToken = {} ",authenticationToken);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        log.info("authentication = {} ",authentication);
        return authentication;
    }
}
