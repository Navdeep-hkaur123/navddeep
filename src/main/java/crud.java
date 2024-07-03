package com.example.login;
public class crud{

    private int ProductID;
    private String ProductName;

    private String PrdouctCategory;

    private String ProductPrice;

    public crud(int ProductID, String ProductName, String PrdouctCategory, String ProductPrice) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.PrdouctCategory= PrdouctCategory;
        this.ProductPrice = ProductPrice;
    }

    public int getId() {
        return ProductID;
    }

    public void setId(int Id) {
        this.ProductID= ProductID;
    }

    public String getName() {
        return ProductName ;
    }

    public void setName(String name) {
        this.ProductName = ProductName;
    }

    public String getEmail() {
        return PrdouctCategory;
    }

    public void setEmail(String email) {
        this.PrdouctCategory = PrdouctCategory;
    }

    public String getPassword() {
        return ProductPrice ;
    }

    public void setPassword(String password) {
        this.ProductPrice= ProductPrice;
    }
}


