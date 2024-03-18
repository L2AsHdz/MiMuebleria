package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.CredentialsDto;
import com.ayd2.mimuebleria.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String signin(CredentialsDto credentials) throws IOException {
        var user = userRepository.findByUsername(credentials.username())
                .orElseThrow(() -> new BadRequestException("Invalida user request"));

        var authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        } else {
            throw new UsernameNotFoundException("Invalid user request !");
        }
    }
}
