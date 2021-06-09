package com.springmvc.urdrive.repository;

import com.springmvc.urdrive.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByStudentID(Integer studentID);
}
