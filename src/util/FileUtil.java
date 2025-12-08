package util;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for file operations
 */
public class FileUtil {

    private FileUtil() {
        // Prevent instantiation
    }

    public static boolean createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                return true;
            } else {
                System.out.println("File '" + file.getName() + "' already exists");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error occurred!");
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static boolean writeLine(String filePath, String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean writeLines(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateLine(String filePath, String id, String newLine) {
        List<String> lines = readLines(filePath);
        boolean updated = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(id)) {
                lines.set(i, newLine);
                updated = true;
                break;
            }
        }
        if (updated) {
            return writeLines(filePath, lines);
        }
        return false;
    }

    public static boolean deleteLine(String filePath, String id) {
        List<String> lines = readLines(filePath);
        boolean removed = lines.removeIf(line -> line.startsWith(id));
        if (removed) {
            return writeLines(filePath, lines);
        }
        return false;
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
