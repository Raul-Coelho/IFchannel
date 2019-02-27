package com.ifpb.model.entidades;

public class User {

    private int id;
    private String email;
    private String password;
    private String name;
    private String sex;
    private byte[] photo;
    private String street;
    private String city;
    private String state;
    private String cep;
    private String phone;
    private String number;

    public User() {
    }

    public User(String email, String password, String name, String sex, byte[] photo, String street, String city,
                String state, String cep, String phone, String number) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.photo = photo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.phone = phone;
        this.number = number;
    }

    public User(int id, String email, String password, String name, String sex, byte[] photo, String street, String city, String state, String cep, String phone, String number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.photo = photo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.phone = phone;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", photo='" + photo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cep='" + cep + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
