package com.example.jwt_redis_logindemo.config.auth;

import com.example.jwt_redis_logindemo.user.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrinsipalDetails implements UserDetails {

    private Member member;

    public PrinsipalDetails(Member member) {
        this.member = member;
    }

    // 해당 Member의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정 비밀번호 기간
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 되어있니?
    @Override
    public boolean isEnabled() {
        return true;
    }
}
