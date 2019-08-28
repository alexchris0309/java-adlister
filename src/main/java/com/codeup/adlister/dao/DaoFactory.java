package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;



public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();
    private static Users user;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users createUser(){
        if(user== null){
            user= new MySQLUsersDao(config);
        }
        return user;
    }
}

