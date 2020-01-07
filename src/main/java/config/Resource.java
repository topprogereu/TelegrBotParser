package config;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Resource {

    private static Resource res = null;
    private String url;
    private String username;
    private String password;

    private Resource() {
        Properties props =  new Properties();
        try
        {
            InputStream in = Files.newInputStream(Paths.get("database.properties"));
            System.out.println(in.read());
            props.load(in);

        }
        catch(Exception e)
        {
            System.out.println("Не удалось прочитать файл");
        }
         url = props.getProperty("url");
        System.out.println("Resource.getUrl "+url);
         username = props.getProperty("username");
         password = props.getProperty("password");
    }

    public static Resource getInstance()
    {
        if (res != null)
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
