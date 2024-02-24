package com.pqm.socialnetwork.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface ApplicationUserDetailsService extends UserDetailsService {
    UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

    UserDetails loadUserById(Long id);
}
