package miu.edu.cs545assignment.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Role;
import miu.edu.cs545assignment.domain.User;
import miu.edu.cs545assignment.domain.dto.request.LoginRequest;
import miu.edu.cs545assignment.domain.dto.request.RefreshTokenRequest;
import miu.edu.cs545assignment.domain.dto.response.LoginResponse;
import miu.edu.cs545assignment.service.AuthService;
import miu.edu.cs545assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/createTestUsers")
    public void createTestUsers() {
        User normalUser = new User();
        normalUser.setEmail("test@mail.com");
        String encodedPassword = passwordEncoder.encode("1234");
        normalUser.setPassword(encodedPassword);
        userService.save(normalUser);

        User adminUser = new User();
        adminUser.setEmail("admin@mail.com");
        adminUser.setPassword(encodedPassword);
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        userService.save(adminUser);
        userService.saveRole(adminUser.getId(), adminRole);
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

}

