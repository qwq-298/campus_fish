package com.compusfishqwq.compus_fishqwq.controller;

import com.compusfishqwq.compus_fishqwq.entity.User;
import com.compusfishqwq.compus_fishqwq.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RegisterController
 * -----------------
 * 负责处理注册相关的 HTTP 请求。
 * 
 * POST /register  → 注册新用户
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    // 注册接口
    @PostMapping
public ResponseEntity<?> registerUser(@RequestBody User user) {
   // System.out.println("Received user: " + user.getUsername() + ", email: " + user.getEmail());

    if (registerService.usernameExists(user.getUsername())) {
        //System.out.println("Username exists: " + user.getUsername());
        return ResponseEntity.badRequest().body("Username already exists!");
    }

    if (registerService.emailExists(user.getEmail())) {
        //System.out.println("Email exists: " + user.getEmail());
        return ResponseEntity.badRequest().body("Email already registered!");
    }

    User saved = registerService.register(user);
    //System.out.println("User registered: " + saved.getUsername());
    return ResponseEntity.ok(saved);
}

}

