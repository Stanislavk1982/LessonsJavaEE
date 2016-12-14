package com.model;

public class User {

    private String name;
    private int age;
    private String password;
    private String phone;
    private String email;
    private String adress;

    public User(String name, int age, String password, String phone, String email, String adress) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
