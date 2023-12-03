package com.example.appuser.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.Model.Utilisateur;
import com.example.appuser.R;

public class UtilisateurViewHolder extends RecyclerView.ViewHolder {
    TextView t1,t2,t3,t4,t5;
    public UtilisateurViewHolder(@NonNull View itemView) {
        super(itemView);
        t1=itemView.findViewById(R.id.FN);
        t2=itemView.findViewById(R.id.LN);
        t3=itemView.findViewById(R.id.AG);
        t4=itemView.findViewById(R.id.EM);
        t5=itemView.findViewById(R.id.ID);
    }
    public  void  bind(Utilisateur U){
        t1.setText(U.getFirstName());
        t2.setText(U.getLastName());
        t3.setText(String.valueOf(U.getAge()));
        t4.setText(U.getEmail());
        t5.setText(String.valueOf(U.getId()));
    }
}
