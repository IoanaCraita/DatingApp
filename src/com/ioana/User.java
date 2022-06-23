package com.ioana;

import sun.misc.Service;

import java.util.List;

public class User {
    private String name;
    private int age;
    private Sex sex;
    private int location;
    private List<String> hobbies;

    public User(String name, int age, Sex sex, int location, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.location = location;
        this.hobbies = hobbies;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
