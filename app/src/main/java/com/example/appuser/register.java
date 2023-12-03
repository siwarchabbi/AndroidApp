package com.example.appuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=findViewById(R.id.username);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.password);
        e4=findViewById(R.id.R);
        b1=findViewById(R.id.loginbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                String name=e1.getText().toString();
                e.putString("N",name);
                String email=e2.getText().toString();
                e.putString("l",email);
                String psw=e3.getText().toString();
                e.putString("E",psw);
                String confP=e4.getText().toString();
                e.putString("s",confP);
                if (psw.equals(confP)){
                    e.putString("ps",psw);
                    e.commit();
                    Intent i=new Intent(register.this, sigin.class);
                    startActivity(i);}
                else{
                    Toast.makeText(register.this, "vérifier votre password", Toast.LENGTH_SHORT).show();


                }}


                              }


        );

    }
}
