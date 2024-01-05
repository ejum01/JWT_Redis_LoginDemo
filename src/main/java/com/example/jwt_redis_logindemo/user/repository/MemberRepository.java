package com.example.jwt_redis_logindemo.user.repository;

import com.example.jwt_redis_logindemo.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : ejum
 * @fileName : UserRepository
 * @since : 12/5/23
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);

    @Modifying
    @Query("update member m set m.password = ?2 where m.username = ?1")
    void updatePassword(String username, String encode);


//    PrincipalDetails loadUserByUsername(String username);
}


//    void updatePassword(String userName, String encode);
