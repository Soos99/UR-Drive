package com.springmvc.urdrive.dto;

import lombok.Data;

@Data
public class CredentialDTO {
    private Integer credentialID;
    private String url;
    private String username;
    private String key;
    private String password;
    private Integer userID;
    private String decryptedPassword;
}
