package com.example.jwt_redis_logindemo.config.auth;

import com.example.jwt_redis_logindemo.user.entity.Member;
import com.example.jwt_redis_logindemo.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : ejum
 * @fileName : PrincipalDetailsService
 * @since : 12/7/23
 * 시큐리티 설정에서 loginProcessingUrl("login");
 * login 요청이 오면 자동으로 UserDetailsService 타입으로 Ioc되어 있는 loadUserByUsername 함수가 실행
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;


    // 시큐리티 session = Authentication = UserDetails
    // => 시큐리티 session(내부 Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username = {}", username);
        Member memberEntity = memberRepository.findByUsername(username);

//        log.info("memberEntity = {}", memberEntity.getUsername());
        log.info("memberEntity = {}", memberEntity);
        if(memberEntity != null){
            System.out.println("로그인 됨");
            return new PrinsipalDetails(memberEntity);
        } else {
            System.out.println("로그인 안됨");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }



//    @Override
//    public PrincipalDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("init loadUserByUsername username={}",username);
//        PrincipalDetails principalDetails = userRepository.loadUserByUsername(username);
//        log.info("member = {}", principalDetails);
////        if(principalDetails != null){
////            return principalDetails;
////        }
////        return null;
//        if(principalDetails == null)
//            throw new UsernameNotFoundException(username);
//        return principalDetails;
//    }
}
