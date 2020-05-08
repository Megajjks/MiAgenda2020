package com.example.myagenda.utils;

public class Utils {
    public static final int db_varsion  = 2;
    public static final String dbName = "agenda";

    //Tabla de usuarios
    public static final String table_user   = "users";
    public static final String id_field   = "id";
    public static final String name_field   = "name";
    public static final String email_field = "email";
    public static final String password_field = "password";
    public static final String age_field   = "age";
    public static final String phone_field   = "phone";

    public static final String create_user =String.format("CREATE TABLE %s (%s INTEGER, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s INTEGER)"
            ,table_user,id_field,name_field,email_field,password_field,age_field,phone_field);
}
