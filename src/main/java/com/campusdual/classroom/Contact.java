package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import static java.text.Normalizer.normalize;

public class Contact implements ICallActions {

    String name;
    String lastName;
    String telephone;
    List<String> optionalTelephone;
    String contactCode;
    int choice;

    public Contact(String name, String lastName, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.contactCode = generateCode(name, lastName); //almacena el codigo del contacto
        this.optionalTelephone = new ArrayList<>();

    }

    //funcion para generar el codigo automaticamente
    public String generateCode(String name, String lastName) {
        String processedLastName;

        //normalizar nombre, se eliminan acentos, tildes, y se pasan a minusculas
        String normalizedtName = normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toLowerCase();

        //normalizar apellido, se eliminan acentos y se pasan a minusculas
        String normalizedLastName = normalize(lastName, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "").toLowerCase();

        //inicial del nombre
        String initial = normalizedtName.substring(0, 1);

        //divide los apellidos por espacio
        String[] separateLastName = normalizedLastName.split(" ");

        //si solo es un apellido
        if (separateLastName.length == 1) {
            processedLastName = separateLastName[0];
        } else {
            //si hay mas de uno, se toma la letra del primer apellido y el resto del segundoi
            String firstLetter = separateLastName[0].substring(0, 1);
            StringBuilder remainingLastName = new StringBuilder();

            for (int i = 1; i < separateLastName.length; i++) {
                remainingLastName.append(separateLastName[i]);
            }

            processedLastName = firstLetter + remainingLastName;
        }


        return initial + processedLastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOptionalTelephone() {
        return String.join(" ", this.optionalTelephone);
    }


    public void setOptionalTelephone(String optionalTelephone) {
        this.optionalTelephone.add(optionalTelephone);
    }

    public String getCode() {
        return this.contactCode;
    }

    @Override
    public void callMyNumber() {
        System.out.println("\nIncoming call from your own number.... " + this.getName() + " "
                + this.getSurnames() + " " + this.getPhone());
    }

    @Override
    public void callOtherNumber(String number) {

        System.out.println("\n" + this.getName() + " " + this.getSurnames() + " is making a call to..." + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("\nContact Details:");
        System.out.println("Code: " + getCode());
        System.out.println("Name: " + getName());
        System.out.println("Last Name: " + getSurnames());
        System.out.println("Telephone: " + getPhone());
        System.out.println("Optional Numbers: " + getOptionalTelephone());
    }

    public void contactMenu() {
        boolean exit = false;
        do {
            System.out.println("\n1. Call your own number");
            System.out.println("2. Make a call");
            System.out.println("3. Show contact details");
            System.out.println("4. Exit");
            choice = Utils.integer("Choose an option:\n");

            switch (choice) {
                case 1:
                    callMyNumber();
                    break;
                case 2:
                    callOtherNumber((Utils.string("Insert number please: ")));
                    break;
                case 3:
                    showContactDetails();
                    break;
                case 4:
                    System.out.println("\nBye...");
                    exit = true;
            }
        } while (!exit);
    }


}




