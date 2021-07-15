package com.tech.interview.siply.redbus.configuration;

import com.tech.interview.siply.redbus.entity.dao.users.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class RedbusUserDetails implements UserDetails {

    private final User redbusUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(redbusUser.getUserType().name());
        System.out.println(redbusUser.getUserType().name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return redbusUser.getPassword();
    }

    @Override
    public String getUsername() {
        return redbusUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !redbusUser.isAccExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !redbusUser.isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !redbusUser.isCredExpired;
    }

    @Override
    public boolean isEnabled() {
        return redbusUser.isEnabled;
    }
}
