package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder sb = new StringBuilder();
        Profile profile = new Profile();

        try(FileInputStream in = new FileInputStream(file.getAbsolutePath())) {

            int read;

            while ((read = in.read()) != -1) {
                sb.append((char) read);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] pairs = sb.toString().split("\\R");

        for (String pair : pairs){
            String key = pair.split(" ")[0];
            String value = pair.split(" ")[1];
            switch (key) {
                case "Name:":
                    profile.setName(value);
                    break;
                case "Age:":
                    profile.setAge(Integer.parseInt(value));
                    break;
                case "Email:":
                    profile.setEmail(value);
                    break;
                case "Phone:":
                    profile.setPhone(Long.parseLong(value));
                    break;
                default:
                    break;
            }
        }
        return profile;
    }
}
