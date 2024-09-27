package com.swp_group4.back_end.controllers;

import com.swp_group4.back_end.entities.Account;
import com.swp_group4.back_end.requests.CreateAccountRequest;
import com.swp_group4.back_end.requests.LoginRequest;
import com.swp_group4.back_end.responses.ApiResponse;
import com.swp_group4.back_end.responses.LoginResponse;
import com.swp_group4.back_end.services.AccountService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountController {

    @Autowired
    AccountService accountService;

    // Gọi hàm đăng nhập (URL: localhost:8080/login)
    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        return ApiResponse.<LoginResponse>builder()
                .data(accountService.login(request))
                .build();
    }

    // Gọi hàm đăng ký (URL: localhost:8080/register)
    @PostMapping("/register")
    public ApiResponse<Account> register(@RequestBody @Valid CreateAccountRequest request) {
        return ApiResponse.<Account>builder()
                .data(accountService.register(request))
                .build();
    }

    // Gọi hàm đăng xuất (URL: localhost:8080/logout)
//    @PostMapping("/logout")
//    public ApiResponse<String> logout() {
//
//    }

}
