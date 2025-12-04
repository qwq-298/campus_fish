package com.compusfishqwq.compus_fishqwq.service;

import com.compusfishqwq.compus_fishqwq.entity.User;
import com.compusfishqwq.compus_fishqwq.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkLogin(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null)
            return false;

        return user.getPassword().equals(password);
    }

    public User getUser(String username, String password) {
    return userRepository.findByUsernameAndPassword(username, password)
            .orElse(null);
    }

}
