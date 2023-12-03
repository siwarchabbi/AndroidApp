package com.example.appuser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appuser.Model.Utilisateur;
import com.example.appuser.Utils.Apis;
import com.example.appuser.Utils.UtilisateurService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    EditText e1, e2 , e3 , e4, e5;
    Button btn_save ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        e1=findViewById(R.id.eFN);
        e2=findViewById(R.id.eLN);
        e3=findViewById(R.id.eAg);
        e4=findViewById(R.id.eMl);
        e5=findViewById(R.id.eID);
        btn_save=findViewById(R.id.btn);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  fn=e1.getText().toString();
                String ln=e2.getText().toString();
                int a=Integer.valueOf(e3.getText().toString());
                String e=e4.getText().toString();
                int i=Integer.valueOf(e5.getText().toString());
                Utilisateur u=new Utilisateur(i,fn,ln,e,a);
                u.setId(Integer.parseInt(e5.getText().toString()));
                u.setFirstName(e1.getText().toString());
                u.setLastName(e2.getText().toString());
                u.setAge(Integer.parseInt(e3.getText().toString()));
                u.setEmail(e4.getText().toString());
                UtilisateurService apiService= Apis.getUtilisateurService();
                Call<Utilisateur> call=apiService.putUser(u);
                call.enqueue(new Callback<Utilisateur>() {
                    @Override
                    public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                        try {
                            if (response.isSuccessful()){
                                Toast.makeText(UpdateActivity.this, "user Update ", Toast.LENGTH_LONG).show();
                                Intent i=new Intent(UpdateActivity.this,AdminActivity.class);
                                startActivity(i);
                            }else {
                                Toast.makeText(UpdateActivity.this, "error Body", Toast.LENGTH_LONG).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<Utilisateur> call, Throwable t) {
                        Toast.makeText(UpdateActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

                        Log.i("appuser", t.toString());
                    }
                });


            }
        });

    }

}
