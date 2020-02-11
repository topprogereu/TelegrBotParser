package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class Resource {

    private static Resource res = null;
    private String url;
    private String username;
    private String password;

    private Resource() {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/database.properties");
            props.load(fis);
        } catch (Exception e) {
            System.out.println("Не удалось прочитать файл");
        }
        url = props.getProperty("url");
        username = props.getProperty("username");
        password = props.getProperty("password");
    }

    public static Resource getInstance() {
        if (res == null)
            res = new Resource();
        return res;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
