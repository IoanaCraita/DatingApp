package com.ioana;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    private List<User> readUsers() {
        List<User> users = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Users.txt"));
            String st;
            while ((st = reader.readLine()) != null) {
                String[] values = st.split(",");
                List<String> hobbies = new ArrayList<>();
                for (int i = 1; i <= values.length - 1; i++) {
                    hobbies.add(values[i]);
                }

                User user = new User(values[0], Integer.parseInt(values[1]), Sex.valueOf(values[2]), Integer.parseInt(values[3]), hobbies);
                users.add(user);

            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was a problem reading from this file");
            ioException.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public User createProfile() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        User user = null;
        System.out.println("Single and ready to mingle? Lets get started");
        try {
            System.out.println("Name: ");
            String name = reader.readLine();
            System.out.println("Age:");
            int age = Integer.parseInt(reader.readLine());
            System.out.println("Sex: m/F ");
            Sex sex = Sex.valueOf(reader.readLine());
            System.out.println("Location: ");
            int location = Integer.parseInt(reader.readLine());

            System.out.println(" Please select 3 hobbies: acting,cooking,singing,knitting,baking,drawing,photography,zumba,tennis,yoga ");
            List<String> hobbies = new ArrayList<>();
            String[] hobby = reader.readLine().split(" ");
            Collections.addAll(hobbies, hobby[0], hobby[1], hobby[2]);
            user = new User(name, age, sex, location, hobbies);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    //gaseste pers de sex opus, verifica ca diferenta de varsta sa fie de maxim 5 ani ,

    public void findMatch() {
        List<User> users = readUsers();
        User userToMatch = createProfile();
        for (User user: users){
            if (!user.getSex().equals(userToMatch.getSex()) && calcAgeDiff(user, userToMatch) <= 5) {

            }

        }
    }

    private void calcScore(){

    }

    private int calcAgeDiff(User user,  User userToMatch){
        int diff = 0;
        if (user.getAge() >= userToMatch.getAge()) {
             diff = user.getAge() - userToMatch.getAge();
        } else {
            diff = userToMatch.getAge() - user.getAge();
        }
        return diff;
    }

}
