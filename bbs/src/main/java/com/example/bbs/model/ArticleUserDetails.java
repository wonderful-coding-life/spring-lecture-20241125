package com.example.bbs.model;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
public class ArticleUserDetails implements UserDetails {
    // properties for UserDetails
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;

    // extra properties
    private String displayName;
    private Long memberId;

    public ArticleUserDetails(Member member, List<Authority> authorities) {
        this.username = member.getEmail();
        this.password = member.getPassword();
        this.authorities = authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .toList();
        this.displayName = member.getName();
        this.memberId = member.getId();
    }
}
