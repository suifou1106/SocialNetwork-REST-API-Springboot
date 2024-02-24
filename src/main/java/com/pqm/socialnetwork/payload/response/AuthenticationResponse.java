package com.pqm.socialnetwork.payload.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;
}
