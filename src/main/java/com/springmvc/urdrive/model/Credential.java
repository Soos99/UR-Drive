package com.springmvc.urdrive.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CREDENTIALS")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credential_id")
    private Integer credentialID;

    @Column(name = "url")
    private String url;

    @Column(name = "username")
    private String username;

    @Column(name = "credential_key")
    private String key;

    @Column(name = "password")
    private String password;

    @Column(name = "student_id")
    private Integer studentID;
}
