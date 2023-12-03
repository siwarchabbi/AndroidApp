package com.example.appuser.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.MainActivity;
import com.example.appuser.Model.Utilisateur;
import com.example.appuser.R;

import java.util.List;

public class UtilisateurAdapter extends RecyclerView.Adapter<UtilisateurViewHolder> {
    List<Utilisateur> list;

    public UtilisateurAdapter(List<Utilisateur> list) {
        this.list=list;
    }



    @NonNull
    @Override
    public UtilisateurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_utilisateur,parent,false);

        return new UtilisateurViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UtilisateurViewHolder holder, int position) {
        Utilisateur utilisateur=list.get(position);
        holder.bind(utilisateur);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent();
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
