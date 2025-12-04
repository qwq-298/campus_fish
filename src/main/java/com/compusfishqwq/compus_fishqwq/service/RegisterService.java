package com.compusfishqwq.compus_fishqwq.service;

import com.compusfishqwq.compus_fishqwq.entity.User;
import com.compusfishqwq.compus_fishqwq.repository.UserRepository;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class RegisterService {

    private final UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 查询邮箱是否已被注册
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    // 查询用户名是否已存在
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // 执行注册
    public User register(User user) {
        return userRepository.save(user);
    }
}

