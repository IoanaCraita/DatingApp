package com.ioana;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
       User user = service.createProfile();
        System.out.println(user.getName() + user.getSex() + user.getHobbies());

    }
}
