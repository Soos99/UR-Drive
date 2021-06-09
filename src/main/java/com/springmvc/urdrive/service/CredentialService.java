package com.springmvc.urdrive.service;

import com.springmvc.urdrive.dto.CredentialDTO;
import com.springmvc.urdrive.model.Credential;
import com.springmvc.urdrive.repository.CredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CredentialService {
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final CredentialRepository credentialRepository;
    @Autowired
    private final EncryptionService encryptionService;

    public void addCred(Credential credential, String username) {
        // set user id
        Integer studentID = studentService.findStudentIDByUsername(username);

        credential.setStudentID(studentID);
        // set key and password
        String encodedKey = encryptionService.getEncodedKey();
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodedKey);
        credential.setKey(encodedKey);
        credential.setPassword(encryptedPassword);

        credentialRepository.save(credential);
    }

    public void updateCred(Credential credential) {
        // set key and password
        String encodedKey = encryptionService.getEncodedKey();
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodedKey);
        credential.setKey(encodedKey);
        credential.setPassword(encryptedPassword);

        credentialRepository.save(credential);
    }

    public List<CredentialDTO> getCreds(String username) {
        Integer studentID = studentService.findStudentIDByUsername(username);

        List<Credential> creds = credentialRepository.findAllByStudentID(studentID);
        List<CredentialDTO> credsDTO = new ArrayList<>();
        for (Credential cred : creds) {
            CredentialDTO credDTO = new CredentialDTO();
            BeanUtils.copyProperties(cred, credDTO);
            credDTO.setDecryptedPassword(encryptionService.decryptValue(credDTO.getPassword(), credDTO.getKey()));
            credsDTO.add(credDTO);
        }
        return credsDTO;
    }

    public void deleteCred(Integer credID) {
        credentialRepository.deleteById(credID);
    }



}