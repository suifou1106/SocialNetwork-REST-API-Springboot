package com.pqm.socialnetwork.service.impl;

import com.pqm.socialnetwork.model.user.User;
import com.pqm.socialnetwork.repository.UserRepository;
import com.pqm.socialnetwork.security.UserPrincipal;
import com.pqm.socialnetwork.service.ApplicationUserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsServiceImpl implements ApplicationUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with id: %s", id)));
        return UserPrincipal.create(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with this username or email: %s", username)));
        return UserPrincipal.create(user);
    }
}
