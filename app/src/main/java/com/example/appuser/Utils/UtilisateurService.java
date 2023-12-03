package com.example.appuser.Utils;

import com.example.appuser.Model.Utilisateur;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UtilisateurService {
       @GET("User/")
       Call<List<Utilisateur>> getAllUtilisateur();
       @POST("User/")
       Call<Utilisateur> addUtilisateur( @Body Utilisateur utilisateur);
       @PUT("User/")
       Call<Utilisateur>  putUser(@Body Utilisateur utilisateur);
       @DELETE("User/{id}")
       Call<Void> deletUtilisateur(@Path("id")  int id);

}
