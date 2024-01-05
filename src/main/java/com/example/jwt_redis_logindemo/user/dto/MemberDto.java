package com.example.jwt_redis_logindemo.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/** extends JpaRepository<Comment, Long
 * @author : ejum
 * @fileName : UserDto
 * @since : 12/5/23
 */
@Getter
@Setter
public class MemberDto extends User {
    private String username;
    private String password;

    public MemberDto(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MemberDto(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
