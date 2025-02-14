package com.campusdual.classroom;


import java.util.HashMap;
import java.util.Map;

public class Exercise26 {
    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.addContact(new Contact("Ana", "Garces", "777888999"));
        phonebook.addContact(new Contact("Luis", "Lopez-Torres", "785868444"));
        phonebook.addContact(new Contact("Juan", "Martinez Gonzalez", "64854534"));
        phonebook.addContact(new Contact("Laura", "Rodriguez", "64564645"));

        phonebook.phonebookMenu();





    }
}
