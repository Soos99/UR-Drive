package com.springmvc.urdrive.repository;

import com.springmvc.urdrive.model.DriveFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveFileRepository extends JpaRepository<DriveFile,Integer> {
    List<DriveFile> findAllByStudentID(Integer studentID);
}
