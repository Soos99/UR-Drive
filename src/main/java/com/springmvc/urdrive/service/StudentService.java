package com.springmvc.urdrive.service;

import com.springmvc.urdrive.model.Student;
import com.springmvc.urdrive.repository.StudentRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@Service
@Data
@Slf4j
public class StudentService {
    @Autowired
    private final HashService hashService;
    @Autowired
    private final StudentRepository studentRepository;

    public void createStudent(Student student) {
        String encodedSalt = hashService.getEncodedSalt();
        String hashedPassword = hashService.getHashedValue(student.getPassword(), encodedSalt);
        student.setPassword(hashedPassword);
        student.setSalt(encodedSalt);
        studentRepository.save(student);
    }

    public Student findStudentByUsername(String username) {
        return studentRepository.findByUsername(username).orElse(null);
    }

//    public void changePassword(String username, String password) {
//        User user = userMapper.findByUsername(username);
//        String encodedSalt = getEncodedSalt();
//        String hashedPassword = hashService.getHashedValue(password, encodedSalt);
//        user.setPassword(hashedPassword);
//        user.setSalt(encodedSalt);
//        userMapper.save(user);
//    }
//
//    public void deleteAccount(String username) {
//        User user = userMapper.findByUsername(username);
//        userMapper.delete(user);
//    }


}
