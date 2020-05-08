package com.example.myagenda.viewsGeneral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.myagenda.R;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private RecyclerView recycler_users;
    private RecyclerView.Adapter adapter_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //Para desaparecer el Toolbar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);

        //datos
        List users = new ArrayList();
        users.add(new Users("1","Alberto Diaz","alberto@mail.com","1234","22","9991112233"));
        users.add(new Users("2","Pepe mor","pepe@mail.com","1234","22","9995550033"));

    }
}
