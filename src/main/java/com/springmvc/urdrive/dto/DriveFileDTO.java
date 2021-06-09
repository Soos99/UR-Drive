package com.springmvc.urdrive.dto;

import lombok.Data;

@Data
public class DriveFileDTO {
    private Integer fileID;
    private String fileName;
    private String contentType;
    private String fileSize;
    private Integer studentID;
    private String location;
    private byte[] fileData;
}
