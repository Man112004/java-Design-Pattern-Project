package com.example.Session1;

public class AppConfig {

    private static AppConfig instance;

    private String appname;
    private String version;

    private AppConfig() {
        appname = "FaceBook";
        version = "10.0";
    }

    public static AppConfig getInstance() {

        if (instance == null) {
            instance = new AppConfig();
        }

        return instance;
    }

    public static void main(String[] args) {

        AppConfig obj1 = AppConfig.getInstance();
        AppConfig obj2 = AppConfig.getInstance();

        System.out.println("App Name " + obj1.appname);
        System.out.println("Version " + obj1.version);

        System.out.println("Both objects are same " + (obj1 == obj2));
    }
}