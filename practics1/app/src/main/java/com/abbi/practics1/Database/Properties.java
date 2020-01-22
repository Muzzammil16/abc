package com.abbi.practics1.Database;

public class Properties {

    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;
    private String phonenumber;

    public String getFirstName()
    {
        return firstname;
    }
    public String getLastName()
    {
        return lastname;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getAddress()
    {
        return address;
    }
    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setFirstName(String Firstname)
    {
        this.firstname = Firstname;
    }
    public void setLastName(String Lastname)
    {
        this.lastname = Lastname;
    }
    public void setEmail(String Email)
    {
        this.email = Email;
    }
    public void setPassword(String Password)
    {
        this.password = Password;
    }
    public void setAddress(String Address)
    {
        this.address= Address;
    }
    public void setPhonenumber(String Phonenumber)
    {
        this.phonenumber = Phonenumber;
    }
}
