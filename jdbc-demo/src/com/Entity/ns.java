package com.Entity;

public class ns {

    private  String user;
    private  String password;
    private String phone;
    private  String address;
    private  int id;

    public ns() {
    }

    public ns(String user, int id, String password, String phone, String address) {
        this.user = user;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.id = id;

    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ns{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
