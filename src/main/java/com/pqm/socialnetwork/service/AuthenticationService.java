package com.pqm.socialnetwork.service;

import com.pqm.socialnetwork.payload.request.AuthenticationRequest;
import com.pqm.socialnetwork.payload.request.RegisterRequest;
import com.pqm.socialnetwork.payload.response.AuthenticationResponse;

public interface AuthenticationService {
     AuthenticationResponse register(RegisterRequest request);
     AuthenticationResponse authenticate(AuthenticationRequest request);
}
