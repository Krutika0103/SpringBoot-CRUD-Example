package com.krutika.springbootproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class FileService {

    @Value("${file.path}")
    private String filePath;

    public void createEntry(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
        }
    }

    public List<String> readEntries() throws IOException {
        List<String> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        }
        return entries;
    }

    public void updateEntry(String oldData, String newData) throws IOException {
        List<String> entries = readEntries();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String entry : entries) {
                if (entry.equals(oldData)) {
                    writer.write(newData);
                    found = true; // Indicate that the entry was found and updated
                } else {
                    writer.write(entry);
                }
                writer.newLine();
            }
        }

        if (!found) {
            throw new IOException("Entry not found for update: " + oldData);
        }
    }

    public void deleteEntry(String data) throws IOException {
        List<String> entries = readEntries();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String entry : entries) {
                if (!entry.equals(data)) {
                    writer.write(entry);
                    writer.newLine();
                }
            }
        }
    }
}
