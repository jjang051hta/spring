package com.jjang051.jpa.dto;

import com.jjang051.jpa.entity.Member02;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {

    private final Member02 loggedMember;

    /*public CustomUserDetails(Member02 loggedMember) {
        this.loggedMember = loggedMember;
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return loggedMember.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return loggedMember.getPassword();
    }

    @Override
    public String getUsername() {
        return loggedMember.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
