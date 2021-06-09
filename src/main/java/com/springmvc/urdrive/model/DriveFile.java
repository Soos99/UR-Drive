package com.springmvc.urdrive.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FILES")
public class DriveFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer fileID;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "file_size")
    private String fileSize;

    @Column(name = "student_id")
    private Integer studentID;

    @Column(name = "file_data")
    private byte[] fileData;
}
