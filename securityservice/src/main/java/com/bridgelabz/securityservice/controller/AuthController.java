package com.bridgelabz.securityservice.controller;

import com.bridgelabz.securityservice.dto.LoginDTO;
import com.bridgelabz.securityservice.dto.RegisterDTO;
import com.bridgelabz.securityservice.dto.UserDTO;
import com.bridgelabz.securityservice.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> singup(@Valid @RequestBody RegisterDTO sinupDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(sinupDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDto, HttpServletResponse response) {
        String token = userService.loginUser(loginDto);
        return ResponseEntity.accepted().body(token);

    }
}