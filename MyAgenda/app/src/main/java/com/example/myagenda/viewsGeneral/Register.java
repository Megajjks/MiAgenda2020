package com.example.myagenda.viewsGeneral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myagenda.openHelper.SQLiteOpenHelper;
import com.example.myagenda.utils.Utils;


import com.example.myagenda.R;

public class Register extends AppCompatActivity {

    private ImageButton btn_backHome;
    private Button btn_add_user;
    private EditText name, age, phone, email, password;
    SQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Para desaparecer el Toolbar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);

        //declaramos la coneccion a la db
        conn = new SQLiteOpenHelper(this,Utils.dbName,null,Utils.db_varsion);

        name = findViewById(R.id.input_nombre);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        age = findViewById(R.id.input_edad);
        phone = findViewById(R.id.input_telefono);
        btn_backHome = findViewById(R.id.btn_backinregister);
        btn_add_user = findViewById(R.id.btn_add_user);

        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InitialView.class);
                startActivity(intent);
            }
        });

        btn_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, correo, pass;
                int id, edad, tel;

                id = 1;
                nombre = name.getText().toString().trim();
                correo = email.getText().toString().trim();
                pass = password.getText().toString().trim();
                edad = Integer.parseInt(age.getText().toString().trim());
                tel = Integer.parseInt(phone.getText().toString().trim());

                storeUser(id,nombre,correo,pass, edad, tel);
            }
        });
    }

    private void storeUser(int id, String name, String email, String password, int age, int phone){
        SQLiteDatabase db = conn.getWritableDatabase();
        String insert = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES (%d,'%s','%s','%s',%d,%d)"
                ,Utils.table_user
                ,Utils.id_field
                ,Utils.name_field
                ,Utils.email_field
                ,Utils.password_field
                ,Utils.age_field
                ,Utils.phone_field
                ,id,name,email,password,age,phone);

        db.execSQL(insert);
        db.close();
        Toast.makeText(getApplicationContext(),"usuario registrado",Toast.LENGTH_SHORT).show();
    }
}
