package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.dto.CredentialsDto;
import com.ayd2.mimuebleria.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<String> getToken(@RequestBody CredentialsDto credentials) throws IOException {
        return ResponseEntity.ok(authenticationService.signin(credentials));
    }
}
