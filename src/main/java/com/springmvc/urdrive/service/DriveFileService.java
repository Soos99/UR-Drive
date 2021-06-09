package com.springmvc.urdrive.service;

import com.springmvc.urdrive.model.DriveFile;
import com.springmvc.urdrive.dto.DriveFileDTO;
import com.springmvc.urdrive.repository.DriveFileRepository;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class DriveFileService {
    private final StudentService studentService;
    private final DriveFileRepository driveFileRepository;

    public void addDriveFile(MultipartFile multipartFile, String username) {
        try {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            Integer studentID = studentService.findStudentIDByUsername(username);

            // set attributes
            DriveFile driveFile = new DriveFile();
            driveFile.setFileName(fileName);
            driveFile.setContentType(multipartFile.getContentType());
            driveFile.setFileSize("" + multipartFile.getSize());
            driveFile.setFileData(multipartFile.getBytes());
            driveFile.setStudentID(studentID);

            driveFileRepository.save(driveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getLocation(DriveFile driveFile) {
        String base64 = Base64.getEncoder().encodeToString(driveFile.getFileData());
        return "data:" + driveFile.getContentType() + ";base64," + base64;
    }

    public List<DriveFileDTO> getDriveFiles(String username) {
        Integer studentID = studentService.findStudentIDByUsername(username);
        List<DriveFile> files = driveFileRepository.findAllByStudentID(studentID);
        List<DriveFileDTO> filesDTO = new ArrayList<>();
        for (DriveFile file : files) {
            DriveFileDTO fileDTO = new DriveFileDTO();
            BeanUtils.copyProperties(file,fileDTO);
            fileDTO.setLocation(getLocation(file));
            filesDTO.add(fileDTO);
        }
        return filesDTO;
    }

    public void deleteDriveFile(Integer fileID) {
        driveFileRepository.deleteById(fileID);
    }
}
