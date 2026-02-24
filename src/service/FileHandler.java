package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String RESOURCE_DIR = "/data/";

    public static void writeLineToFile(String fileName, String data) {
        File dataFile = ensureDataFile(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }

    public static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = ensureDataFile(fileName);
        
        if (!file.exists()) return lines; 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file " + fileName + ": " + e.getMessage());
        }
        return lines;
    }

    public static void writeLinesToFile(String fileName, List<String> lines) {
        File dataFile = ensureDataFile(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, false))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }

    private static File ensureDataFile(String fileName) {
        File dataFile = new File(fileName);
        if (!dataFile.isAbsolute()) {
            dataFile = new File(System.getProperty("user.dir"), fileName);
        }
        File parent = dataFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        if (!dataFile.exists()) {
            copyFromResourceIfAvailable(fileName, dataFile);
        }
        return dataFile;
    }

    private static void copyFromResourceIfAvailable(String fileName, File target) {
        String resourcePath = RESOURCE_DIR + new File(fileName).getName();
        try (InputStream input = FileHandler.class.getResourceAsStream(resourcePath)) {
            if (input == null) {
                return;
            }
            try (OutputStream output = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            System.err.println("Error initializing file " + fileName + ": " + e.getMessage());
        }
    }
}