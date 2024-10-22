package com.krutika.springbootproject.controller;

import com.krutika.springbootproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    public ResponseEntity<String> createEntry(@RequestBody String data) throws IOException {
        fileService.createEntry(data);
        return ResponseEntity.ok("Entry created successfully");
    }

    @GetMapping("/read")
    public ResponseEntity<List<String>> readEntries() throws IOException {
        List<String> entries = fileService.readEntries();
        return ResponseEntity.ok(entries);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEntry(@RequestParam String oldData, @RequestParam String newData) throws IOException {
        fileService.updateEntry(oldData, newData);
        return ResponseEntity.ok("Entry updated successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEntry(@RequestParam String data) throws IOException {
        fileService.deleteEntry(data);
        return ResponseEntity.ok("Entry deleted successfully");
    }
}
