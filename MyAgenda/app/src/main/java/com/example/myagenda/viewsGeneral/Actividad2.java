package com.example.myagenda.viewsGeneral;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myagenda.R;
import com.example.myagenda.openHelper.SQLiteOpenHelper;
import com.example.myagenda.utils.Utils;

public class Actividad2 extends AppCompatActivity {

    private Button btn_add, btn_edit, btn_delete, btn_consult;
    private EditText name, age, phone, email, password, id;
    SQLiteOpenHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Para desaparecer el Toolbar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_actividad2);

        //declaramos la coneccion a la db
        conn = new SQLiteOpenHelper(this, Utils.dbName,null,Utils.db_varsion);
        id = findViewById(R.id.input_id);
        name = findViewById(R.id.input_nombre);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        age = findViewById(R.id.input_edad);
        phone = findViewById(R.id.input_telefono);
        btn_add = findViewById(R.id.btn_add_user2);
        btn_edit = findViewById(R.id.btn_edit);
        btn_consult = findViewById(R.id.btn_consult);
        btn_delete = findViewById(R.id.btn_delete);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, correo, pass;
                int id, edad, tel;

                id = getLastID()+1;
                nombre = name.getText().toString().trim();
                correo = email.getText().toString().trim();
                pass = password.getText().toString().trim();
                edad = Integer.parseInt(age.getText().toString().trim());
                tel = Integer.parseInt(phone.getText().toString().trim());

                storeUser(id,nombre,correo,pass, edad, tel);
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(Integer.parseInt(id.getText().toString().trim()));
            }
        });

        btn_consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulta(new String[]{"%pepe%"});
                Toast.makeText(getApplicationContext(),"Consultando usuario",Toast.LENGTH_SHORT).show();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(Integer.parseInt(id.getText().toString().trim()));
                Toast.makeText(getApplicationContext(),"Borrando usuario",Toast.LENGTH_SHORT).show();
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

    private int getLastID(){
        try {
            SQLiteDatabase db = conn.getReadableDatabase();

            String query = "SELECT id FROM users ORDER by id DESC";
            Cursor c = db.rawQuery(query,null);
            c.moveToFirst();
            return c.getShort(0);
        }
        catch (Exception ex){
            return 0;
        }

    }

    private void delete(int id){
        SQLiteDatabase db = conn.getWritableDatabase();
        String delete = String.format("DELETE FROM %s WHERE %s = %d",
                Utils.table_user,Utils.id_field,id);
        db.execSQL(delete);
        db.close();
    }

    private void consulta(String args[]){
        SQLiteDatabase db = conn.getReadableDatabase();

        String query = String.format("SELECT id,name FROM %s WHERE %s LIKE ?",
                Utils.table_user,Utils.name_field);
        Cursor c = db.rawQuery(query,args);
        c.moveToFirst();
        Toast.makeText(getApplicationContext(),c.getString(1),Toast.LENGTH_SHORT).show();
        c.close();
    }

    private void update(int id){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] pars = {""+id};
        String update = String.format("UPDATE %s SET %s='%s' WHERE %s = ?"
                ,Utils.table_user
                ,Utils.name_field
                ,"Jayro Salazar"
                ,Utils.id_field);
        db.execSQL(update,pars);
        db.close();
    }
}
