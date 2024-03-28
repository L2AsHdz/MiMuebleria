package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.model.User;
import com.ayd2.mimuebleria.model.UserInfoDetails;
import com.ayd2.mimuebleria.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void changeStatus(Long userId, Short status) throws NotFoundException {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.setStatus(status);
        userRepository.save(user);
    }

}
