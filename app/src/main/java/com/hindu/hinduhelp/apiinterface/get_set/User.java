package com.hindu.hinduhelp.apiinterface.get_set;

public class User {
    int id;
    String fname,lname,mobileno,email,address,pincode,state,dist;

    public User(int id, String fname, String lname, String mobileno, String email, String address, String pincode, String state, String dist) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mobileno = mobileno;
        this.email = email;
        this.address = address;
        this.pincode = pincode;
        this.state = state;
        this.dist = dist;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }


}
