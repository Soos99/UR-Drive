package com.springmvc.urdrive.service;

import com.springmvc.urdrive.model.Note;
import com.springmvc.urdrive.repository.NoteRepository;
import com.springmvc.urdrive.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final NoteRepository noteRepository;

    public void addNote(Note note, String username) {
        Integer studentID = studentService.findStudentByUsername(username).getStudentID();
        note.setStudentID(studentID);
        noteRepository.save(note);
    }

    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    public List<Note> getNotes(String username) {
        Integer userID = studentService.findStudentIDByUsername(username);
        return noteRepository.findAllByStudentID(userID);
    }

    public void deleteNote(Integer noteID) {
        noteRepository.deleteById(noteID);
    }
}
