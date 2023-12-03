package com.example.appuser.Model;
public class Utilisateur {
    private int id;
    private  String fristName;
    private  String lastName;
    private  String mail;
    private int age;

    public Utilisateur(int id ,String fristName, String lastName, String mail, int age) {
        this.id = id;
        this.fristName = fristName;
        this.lastName = lastName;
        this.mail = mail;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return fristName;
    }

    public void setFirstName(String firstName) {
        this.fristName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                '}';
    }
}
