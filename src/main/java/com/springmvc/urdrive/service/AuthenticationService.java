package com.springmvc.urdrive.service;

import com.springmvc.urdrive.model.Student;
import com.springmvc.urdrive.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class AuthenticationService implements AuthenticationProvider {
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final HashService hashService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Student student = studentService.findStudentByUsername(username);
        if (student != null) {
            String encodedSalt = student.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (student.getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
