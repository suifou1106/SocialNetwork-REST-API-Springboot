package com.pqm.socialnetwork.payload.request;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
}
