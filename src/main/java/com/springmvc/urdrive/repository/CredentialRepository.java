package com.springmvc.urdrive.repository;

import com.springmvc.urdrive.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
    List<Credential> findAllByStudentID(Integer studentID);
}
