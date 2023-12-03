package com.example.appuser.Utils;

public class Apis {
    public  static final  String URL="http://10.0.2.2:8080/";
    public  static  UtilisateurService getUtilisateurService(){
        return  Client.getRetrofit(URL).create(UtilisateurService.class);
    }
}
