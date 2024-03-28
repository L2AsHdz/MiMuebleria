package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.dto.user.UserRequestDto;
import com.ayd2.mimuebleria.exceptions.DuplicatedEntityException;
import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.model.User;
import com.ayd2.mimuebleria.service.AuthenticationService;
import com.ayd2.mimuebleria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto userRequestDto) throws DuplicatedEntityException {
        var createdUser =  authenticationService.signup(userRequestDto);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) throws ServiceException {
        var updatedUser = authenticationService.updateUser(id, userRequestDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<Void> enableUser(@PathVariable Long id) throws NotFoundException {
        userService.changeStatus(id, (short)1);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("disable/{id}")
    public ResponseEntity<Void> disableUser(@PathVariable Long id) throws NotFoundException {
        userService.changeStatus(id, (short)0);
        return ResponseEntity.accepted().build();
    }
}
