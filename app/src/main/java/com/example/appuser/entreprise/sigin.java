package com.example.appuser.entreprise;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appuser.R;

public class sigin extends AppCompatActivity {

    EditText e1,e2;
    Button btn_cox,btn_ins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin2);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.password);
        btn_cox=findViewById(R.id.loginbtn);
        btn_cox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l=e1.getText().toString();
                String P=e2.getText().toString();
                if (l.isEmpty() || P.isEmpty())
                    Toast.makeText(sigin
                            .this , "champs vides", Toast.LENGTH_SHORT).show();
                else{
                    SharedPreferences sp=getSharedPreferences("MyPref",MODE_PRIVATE);
                    String login=sp.getString("l",null);
                    String psw=sp.getString("ps",null);
                    if(!l.equals(login)|| !P.equals(psw))
                        Toast.makeText(sigin.this,"champs incorrects",Toast.LENGTH_SHORT).show();
                    else {

                        Intent i=new Intent(sigin.this, MainActivity.class);

                        //i.putExtra("login", login);
                        startActivity(i);

                    }
                }


            }
        });
        btn_ins=findViewById(R.id.inscri);
        btn_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(sigin.this,register.class);
                startActivity(i);
            }
        });
    }
}