package com.company;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    List<Person> persons = new ArrayList<>();

    public Group(String name) {

        this.name
                = name;
    }

    public void add(Person person) {
        persons.add(person);
    }

    public void add(List<Person> persons) {
        persons.addAll(persons);
    }

    public int getSize() {
        return persons.size();
    }

    public String getName() {
        return name;
    }

}
