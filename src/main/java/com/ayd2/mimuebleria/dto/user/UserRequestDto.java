package com.ayd2.mimuebleria.dto.user;

import com.ayd2.mimuebleria.enums.Rol;
import com.ayd2.mimuebleria.model.User;

public record UserRequestDto(String name, String username, String password, String email, String role) {

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .username(username)
                .password(password)
                .role(Rol.valueOf(role.toUpperCase()))
                .status((short)1)
                .build();
    }
}
