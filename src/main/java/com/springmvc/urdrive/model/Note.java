package com.springmvc.urdrive.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "NOTES")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer noteID;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_description")
    private String noteDescription;

    @Column(name = "student_id")
    private Integer studentID;
}
