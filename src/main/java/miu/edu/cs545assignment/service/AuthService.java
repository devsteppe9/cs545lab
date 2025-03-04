package miu.edu.cs545assignment.service;

import miu.edu.cs545assignment.domain.dto.request.LoginRequest;
import miu.edu.cs545assignment.domain.dto.response.LoginResponse;
import miu.edu.cs545assignment.domain.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
