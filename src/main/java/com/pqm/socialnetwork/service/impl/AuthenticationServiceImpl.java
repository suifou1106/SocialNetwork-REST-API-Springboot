package com.pqm.socialnetwork.service.impl;

import com.pqm.socialnetwork.exception.AppException;
import com.pqm.socialnetwork.model.role.Role;
import com.pqm.socialnetwork.model.role.RoleName;
import com.pqm.socialnetwork.repository.RoleRepository;
import com.pqm.socialnetwork.model.user.User;
import com.pqm.socialnetwork.payload.request.AuthenticationRequest;
import com.pqm.socialnetwork.payload.request.RegisterRequest;
import com.pqm.socialnetwork.payload.response.AuthenticationResponse;
import com.pqm.socialnetwork.repository.UserRepository;
import com.pqm.socialnetwork.security.JwtTokenProvider;
import com.pqm.socialnetwork.security.UserPrincipal;
import com.pqm.socialnetwork.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        List<Role> roles = new ArrayList<>();
        roles.add(
                roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("User role not set")));
        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        var jwtToken = jwtTokenProvider.generateToken(userPrincipal);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtTokenProvider.generateToken(UserPrincipal.create(user));
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}
