package com.horsika.upvoterapp.controller;

import com.horsika.upvoterapp.dto.RegisterLoginCommand;
import com.horsika.upvoterapp.dto.TokenResponse;
import com.horsika.upvoterapp.service.AuthService;
import com.horsika.upvoterapp.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterLoginCommand command) {
        authService.register(command);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody RegisterLoginCommand command) {
        return new ResponseEntity<>(authService.authenticate(command), HttpStatus.OK);
    }

}
