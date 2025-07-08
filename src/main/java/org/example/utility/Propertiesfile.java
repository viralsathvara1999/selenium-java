package org.example.utility;

import java.io.*;
import java.util.Properties;

public class Propertiesfile {

    public static Properties prop;
    public static String localpath = System.getProperty("user.dir");

    public Propertiesfile() {
        readProperties();
    }

    public static void readProperties() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(localpath + File.separator + "src\\main\\resources\\Config.properties"));
            prop = new Properties();
            try {
                prop.load(reader);
                //System.out.println(prop.getProperty("url"));
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static String getDriverpath() {
        String driverpath = prop.getProperty("driverpath");
        if (driverpath != null) return driverpath;
        else throw new RuntimeException("Driverpath is not Found in properties file");

    }

    public static String geturl() {
        String url = prop.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("URL is not Found in properties file");
    }


    public static String getusername() {
        String username1 = prop.getProperty("username1");
        if (username1 != null) return username1;
        else throw new RuntimeException("Username is not Found in properties file");
    }

    public static String getpassword() {
        String password1 = prop.getProperty("password1");
        if (password1 != null) return password1;
        else throw new RuntimeException("Password is not Found in properties file");
    }


}
