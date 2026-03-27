package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.LoginDTO;
import com.bridgelabz.quantitymeasurement.dto.RegisterDTO;
import com.bridgelabz.quantitymeasurement.dto.UserDTO;
import com.bridgelabz.quantitymeasurement.service.UserService;
import com.bridgelabz.quantitymeasurement.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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