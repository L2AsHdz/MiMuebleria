package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.user.CredentialsDto;
import com.ayd2.mimuebleria.dto.user.UserRequestDto;
import com.ayd2.mimuebleria.exceptions.DuplicatedEntityException;
import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.model.User;
import com.ayd2.mimuebleria.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    public User signup(UserRequestDto userRequestDto) throws DuplicatedEntityException {
        var duplicatedUserByUsername = userRepository.findByUsername(userRequestDto.username());
        if (duplicatedUserByUsername.isPresent())
            throw new DuplicatedEntityException("User with username already exists");

        var duplicatedUserByEmail = userRepository.findByEmail(userRequestDto.email());
        if (duplicatedUserByEmail.isPresent())
            throw new DuplicatedEntityException("User with email already exists");

        var newUser = userRequestDto.toUser();
        newUser.setPassword(encoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public User updateUser(Long id, UserRequestDto userRequestDto) throws ServiceException {
        var userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        var duplicatedUsername = userRepository.findByUsernameAndUserIdNot(userRequestDto.username(), id);
        if (duplicatedUsername.isPresent())
            throw new DuplicatedEntityException("User with username already exists");

        var duplicatedEmail = userRepository.findByEmailAndUserIdNot(userRequestDto.email(), id);
        if (duplicatedEmail.isPresent())
            throw new DuplicatedEntityException("User with email already exists");

        userToUpdate.setName(userRequestDto.name());
        userToUpdate.setEmail(userRequestDto.email());
        userToUpdate.setUsername(userRequestDto.username());
        userToUpdate.setPassword(encoder.encode(userRequestDto.password()));

        return userRepository.save(userToUpdate);
    }

    public String signin(CredentialsDto credentials) throws ServiceException, IOException {
        var user = userRepository.findByUsername(credentials.username())
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (!(user.getStatus() == 1))
            throw new ServiceException("User is disabled");

        var authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        } else {
            throw new UsernameNotFoundException("Invalid user credentials");
        }
    }
}
