package com.ayd2.mimuebleria.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/greetings")
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("welcome")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Welcome to MiMuebleria");
    }

    @GetMapping("hello-admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Hello Admin");
    }

    @GetMapping("hello-factory")
    @PreAuthorize("hasAuthority('FACTORY')")
    public ResponseEntity<String> helloFactory(){
        return ResponseEntity.ok("Hello Factory");
    }

    @GetMapping("hello-sales")
    @PreAuthorize("hasAuthority('SALES')")
    public ResponseEntity<String> helloSales(){
        return ResponseEntity.ok("Hello Sales");
    }
}
