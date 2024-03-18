package com.horsika.upvoterapp.service;

import com.horsika.upvoterapp.domain.AppUser;
import com.horsika.upvoterapp.domain.UserRole;
import com.horsika.upvoterapp.dto.RegisterLoginCommand;
import com.horsika.upvoterapp.dto.TokenResponse;
import com.horsika.upvoterapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public void register(RegisterLoginCommand register) {
        AppUser user = new AppUser();
        user.setUserName(register.getUserName());
        user.setPassHash(passwordEncoder.encode(register.getPass()));
        user.setRole(UserRole.USER); // admins are only made by setting the role directly in the db
    }

    public TokenResponse authenticate(RegisterLoginCommand command) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(command.getUserName(), command.getPass())
        );

        AppUser user = userRepository.findByUserName(command.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        String jwtToken = jwtService.generateToken(user);
        return new TokenResponse(jwtToken);
    }


}
