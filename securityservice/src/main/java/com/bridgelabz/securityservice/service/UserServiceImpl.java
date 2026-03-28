package com.bridgelabz.securityservice.service;


import com.bridgelabz.securityservice.dto.LoginDTO;
import com.bridgelabz.securityservice.dto.RegisterDTO;
import com.bridgelabz.securityservice.dto.UserDTO;
import com.bridgelabz.securityservice.mapper.Mapper;
import com.bridgelabz.securityservice.model.User;
import com.bridgelabz.securityservice.repository.UserRepo;
import com.bridgelabz.securityservice.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
 public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final Mapper<RegisterDTO, User> signupRequestMapper;
    private final Mapper<User, UserDTO> userResponseMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @Override
    public UserDTO createUser(RegisterDTO registerDTO) {
        User user = signupRequestMapper.mapTo(registerDTO);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        User savedUser = userRepo.save(user);
        return userResponseMapper.mapTo(savedUser);
    }

    @Override
    public String loginUser(LoginDTO loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        String token = jwtService.generateToken(authentication.getName());
        return token;
    }
}