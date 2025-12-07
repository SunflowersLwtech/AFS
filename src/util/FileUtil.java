package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {


    public FileUtil() {

    }

    public static void main(String[] args) {

        
    }

    public boolean createFile(String newFile) {
        try {
            if (xxx.createNewFile()) {
                System.out.println("File created: " + xxx.getName())
            }
            else {
                System.out.println("File \'" + xxx.getName() + "\' already exists");
            }
        }
        catch (IOException e) {
            System.out.println("Error occured!");
            e.printStackTrace();
        }

        return true;
    }

    public void readFile() {

    }
    
    public boolean updateFile() {
        return true;
    }

    public boolean deleteFile() {
        return true;
    }
}
