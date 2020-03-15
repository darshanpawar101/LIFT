package com.darshan.lift;

public class Data {

    String name;
    String uid;
    String email;
    String phoneno;
    String password;

    public void Data(){

    }

    public Data(String name, String uid, String email, String phoneno, String password) {
        this.name = name;
        this.uid = uid;
        this.email = email;
        this.phoneno = phoneno;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getPassword() {
        return password;
    }
}
