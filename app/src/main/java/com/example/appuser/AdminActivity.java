package com.example.appuser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appuser.Adapter.UtilisateurAdapter;
import com.example.appuser.Model.Utilisateur;
import com.example.appuser.Utils.Apis;
import com.example.appuser.Utils.UtilisateurService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminActivity extends AppCompatActivity {
    EditText editTextId;
    TextView textView;
    Button buttonDelete, btn_add ,btn_up;
    RecyclerView recyclerView;
    List<Utilisateur> UtilisateurList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        initView();
        recyclerView = findViewById(R.id.recycler);
        btn_add = findViewById(R.id.nuttonadd);
        btn_up=findViewById(R.id.nuttonupdat);
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, UpdateActivity.class);
                startActivity(i);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, addActivity.class);
                startActivity(i);
            }
        });
















        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UtilisateurService apiService = Apis.getUtilisateurService();
        Call<List<Utilisateur>> call = apiService.getAllUtilisateur();
        call.enqueue(new Callback<List<Utilisateur>>() {
            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                UtilisateurList = response.body();
                UtilisateurAdapter a = new UtilisateurAdapter(UtilisateurList);
                recyclerView.setAdapter(a);
                recyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Toast.makeText(AdminActivity.this, "Errer fetching", Toast.LENGTH_SHORT).show();
                Log.i("Appuser", t.toString());
            }
        });
    }

    private void initView() {
        editTextId = findViewById(R.id.editTextId);
        buttonDelete = findViewById(R.id.nuttondelet);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDelete_onClick(view);
            }
        });
    }

    private void buttonDelete_onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int id = Integer.parseInt(editTextId.getText().toString());
                UtilisateurService apiService = Apis.getUtilisateurService();
                apiService.deletUtilisateur(id).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        try {
                            if (response.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "delet succefull", Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();

                            }

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}