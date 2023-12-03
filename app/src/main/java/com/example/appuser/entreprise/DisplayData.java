package com.example.appuser.entreprise;

import static com.example.appuser.entreprise.DBmain.TABLENAME;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuser.R;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {
DBmain dBmain;
SQLiteDatabase sqLiteDatabase;
RecyclerView recyclerView;
MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        setTitle("Stagi.tn");

        dBmain= new DBmain(this);
        findId();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    private void displayData() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLENAME+"",null);
        ArrayList<Model>models=new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            byte[]avatar=cursor.getBlob(1);
            String name=cursor.getString(2);
            models.add(new Model(id,avatar,name));
        }
        cursor.close();
        myAdapter=new MyAdapter(this,R.layout.singledata,models,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }

    private void findId() {
        recyclerView=findViewById(R.id.rv);
    }
}