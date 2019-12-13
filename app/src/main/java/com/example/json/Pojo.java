package com.example.json;


public class Pojo {

    String Email;
    Integer Id;
    String Firstname;
    String Lastname;

    public Pojo (){

    }
    public Pojo(String email, int id, String firstname,String lastname) {
        this.Email = email;
        this.Id = id;
        this.Firstname = firstname;
        this.Lastname=lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;

    }


    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;

    }
    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;

    }
}