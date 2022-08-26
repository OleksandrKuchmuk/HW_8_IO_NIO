package com.cursor.Task5;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private transient Credentials credentials;

    public User(String name, int age, Credentials credentials) {
        this.name = name;
        this.age = age;
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
