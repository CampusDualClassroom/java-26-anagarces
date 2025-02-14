package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    int choice;
    Map<String, Contact> phoneBook;

    //constructor
    public Phonebook() {
        this.phoneBook = new HashMap<>();
    }

    //Añadir un contacto al listin telefonico
    public void addContact(Contact contact) {
        phoneBook.put(contact.getCode(), contact);
        System.out.println("New contact added.");
    }

    public Map<String, Contact> getData() {
        return this.phoneBook;
    }


    //Mostrar los contactos del listín telefónico
    public void showPhonebook() {
        //si esta vacio
        if (phoneBook.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("Contacts: ");
            for (Contact contact : phoneBook.values()) {
                contact.showContactDetails();
            }
        }

    }

    //Seleccionar un contacto y mostrar su menú de acciones
    public Contact selectContact(String contactCode) {
        Contact getContactByCode = phoneBook.get(contactCode);

        if (getContactByCode == null) {
            System.out.println("Contact not found " + contactCode);
        } else {
            System.out.println("\nSelected contact :");
            getContactByCode.showContactDetails();
            getContactByCode.contactMenu();

        }

        return getContactByCode;
    }

    //Eliminar un contacto
    public void deleteContact(String contactCode) {

        //verificamos si la clave existe en el mapa
        if (phoneBook.containsKey(contactCode)) {
            phoneBook.remove(contactCode);
            System.out.println("removed!");
        } else {
            System.out.println("Contact not found: " + contactCode);
        }
    }

    public void phonebookMenu() {
        boolean exit = false;
        do {
            System.out.println("\n####MENU####");
            System.out.println("1. Add contact");
            System.out.println("2. Show all contacts");
            System.out.println("3. Select contact and show menu");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
            choice = Utils.integer("Choose an option:\n");

            switch (choice) {
                case 1:
                    String name = Utils.string("\nInsert name: ");
                    String lastName = Utils.string("\nInsert last name: ");
                    String telephone = Utils.string("\nInsert telephone number: ");
                    Contact contact = new Contact(name, lastName, telephone);
                    String optionalTelephone = Utils.string("\nInsert optional telephone: ");
                    contact.setOptionalTelephone(optionalTelephone);
                    addContact(contact);
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    String selectedContactCode = Utils.string("\nInsert contact code you want to select: ");
                    selectContact(selectedContactCode);
                    break;
                case 4:
                    String contactToDelete = Utils.string("\nInsert contact code you want to delete: ");
                    deleteContact(contactToDelete);
                    break;
                case 5:
                    System.out.println("\nBye...");
                    exit = true;
                    break;
                default:
                    System.out.println("\nError. Invalid option.");
                    break;
            }
        } while (!exit);
    }

}


