package com.codeup.adlister.dao;

public class Config {

    private static String url="jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private static String user="aduser";
    private static String password="pass";

    public static String getUrl() {
        return url;
    }
    public static String getUsername() {
        return user;
    }
    public static String getPassword() {
        return password;
    }
}
