package com.example.myagenda.viewsGeneral;

import java.io.Serializable;

public class Users implements Serializable {
    String _id, _name, _email, _password, _age, _phone;

    public Users(String _id, String _name, String _email, String _password, String _age, String _phone) {
        this._id = _id;
        this._name = _name;
        this._email = _email;
        this._password = _password;
        this._age = _age;
        this._phone = _phone;
    }

    public String get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_email() {
        return _email;
    }

    public String get_password() {
        return _password;
    }

    public String get_age() {
        return _age;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_age(String _age) {
        this._age = _age;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }
}
