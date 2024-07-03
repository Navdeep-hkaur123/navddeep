package com.example.login;
public class login{

    private int ID;
    private String UserName;

    private String Email;

    private String Password;

    public login(int ID, String UserName, String Email, String Password) {
        this.ID = ID;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
    }

    public int getId() {
        return ID;
    }

    public void setId(int Id) {
        this.ID= ID;
    }

    public String getName() {
        return UserName;
    }

    public void setName(String name) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = Password;
    }
}

