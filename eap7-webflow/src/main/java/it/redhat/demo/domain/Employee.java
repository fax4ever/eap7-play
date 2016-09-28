package it.redhat.demo.domain;

import java.io.Serializable;

/**
 * Created by fabio on 27/09/16.
 */
public class Employee implements Serializable {

    private String name;
    private String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void changeCase() {
        name = name.toUpperCase();
        surname = surname.toLowerCase();
    }

}
