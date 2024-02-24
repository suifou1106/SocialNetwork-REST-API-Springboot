package com.pqm.socialnetwork.payload.request;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
