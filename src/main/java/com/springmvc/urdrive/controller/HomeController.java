package com.springmvc.urdrive.controller;

import com.springmvc.urdrive.model.DriveFile;
import com.springmvc.urdrive.model.Note;
import com.springmvc.urdrive.service.DriveFileService;
import com.springmvc.urdrive.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private DriveFileService driveFileService;

    @GetMapping({"/","/home"})
    public String getHomePage(Model model, Principal principal) {
        if (model.getAttribute("active") == null) {
            model.addAttribute("active", "file");
        }
//        model.addAttribute("credentials", credentialService.getCreds(principal.getName()));
        model.addAttribute("notes", noteService.getNotes(principal.getName()));
        model.addAttribute("files", driveFileService.getDriveFiles(principal.getName()));
        return "home";
    }

    @PostMapping("/add-file")
    public String addFile(@RequestParam("file") MultipartFile multipartFile, Principal principal, RedirectAttributes redirectAttributes) {
        driveFileService.addDriveFile(multipartFile, principal.getName());
        redirectAttributes.addFlashAttribute("active", "file");
        return "redirect:/";
    }

    @GetMapping("/delete-file")
    public String deleteFile(@RequestParam("id") Integer fileID, RedirectAttributes redirectAttributes) {
        driveFileService.deleteDriveFile(fileID);
        redirectAttributes.addFlashAttribute("active", "file");
        return "redirect:/";
    }

    @PostMapping("/update-note")
    public String updateNote(Note note, Principal principal, RedirectAttributes redirectAttributes) {
        if (note.getNoteID() > 0 && note.getNoteID() != null) {
            noteService.updateNote(note);
        } else {
            noteService.addNote(note, principal.getName());
        }
        redirectAttributes.addFlashAttribute("active", "note");
        return "redirect:/";
    }

    @GetMapping("/delete-note")
    public String deleteNote(@RequestParam("id") Integer noteID, RedirectAttributes redirectAttributes) {
        noteService.deleteNote(noteID);
        redirectAttributes.addFlashAttribute("active", "note");
        return "redirect:/";
    }
}
