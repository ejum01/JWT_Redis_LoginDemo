package com.example.jwt_redis_logindemo.user.service;

import com.example.jwt_redis_logindemo.jwt.JwtUtil;
import com.example.jwt_redis_logindemo.user.dto.SingUpDto;
import com.example.jwt_redis_logindemo.user.entity.Member;
import com.example.jwt_redis_logindemo.user.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Long expiredMs = 1000 * 60 * 60L;


    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(String userName, String password) {
        String jwtToken = JwtUtil.createJwt(userName, expiredMs);
        log.info("JwtUtil.createJwt = {}", jwtToken);
        memberRepository.findByUsername(userName);
        return jwtToken;
    }


    @Override
    public String getJWtToken() {
        return null;
    }

    // 회원가입
    @Override
    public void registerUser(SingUpDto singUpDto) {
        String encodedPassword = passwordEncoder.encode(singUpDto.getPassword());

        // 회원 등록
        Member newMember = Member.builder()
                .username(singUpDto.getUsername())
                .password(encodedPassword)
                .email(singUpDto.getEmail())
                .role(singUpDto.getRole())
                .build();
        memberRepository.save(newMember);

    }
}
