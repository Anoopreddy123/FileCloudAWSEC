package com.FileCloud.FileCloud.Controller;

import com.FileCloud.FileCloud.entity.users;
import com.FileCloud.FileCloud.service.CustomUserDetails;
import com.FileCloud.FileCloud.service.CustomUserDetailsService;
import com.FileCloud.FileCloud.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userService;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the FileCloud!";
    }
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody users user) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String jwt = jwtUtil.generateToken(user.getUsername());
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            Long userId = userDetails.getId();
            return ResponseEntity.ok(new AuthenticationResponse(jwt, userId));
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody users user) {
        if (userService.usernameExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    static class AuthenticationResponse {
        private final String jwt;
        private final Long userId;

        public AuthenticationResponse(String jwt, Long userId) {
            this.jwt = jwt;
            this.userId = userId;
        }

        public String getJwt() {
            return jwt;
        }

        public Long getUserId() {
            return userId;
        }
    }
}
