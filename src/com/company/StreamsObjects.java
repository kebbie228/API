package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsObjects {
    public static void main(String[] args) {
        Group dep1 = new Group("dep 1");
        Group dep2 = new Group("dep 2");
        Group dep3 = new Group("dep 3");

        List<Person> persons = new ArrayList<Person>(Arrays.asList(
                new Person(dep1, "Ivan", "Ivanov", 30),
                new Person(dep1, "Petr", "Petrov", 66),
                new Person(dep1, "John", "Doe", 40),
                new Person(dep1, "Vlad", "Vladimirov", 40),
                new Person(dep2, "Ivan", "Ivanov", 30),
                new Person(dep2, "Petr", "Petrov", 67),
                new Person(dep2, "John", "Doe", 40),
                new Person(dep3, "Ivan", "Ivanov", 30),
                new Person(dep3, "Petr", "Petrov", 60),
                new Person(dep3, "John", "Doe", 40)
        )
        );
//группы с пенсионерами
        persons.stream()
                .filter(p->p.getAge()>65)
                .map(Person::getGroup)
                .distinct()// уникальность
                .forEach(g->System.out.println(g.getName()));

        //Найти средний возраст всех сотрудников
        double avg=persons.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(Double.NaN);
        System.out.println(avg);

        //Найти отдел с максимальным числом сотрудников
        Map<String, Long> result=persons.stream()
                .map(p->p.getGroup().getName())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String name=result.entrySet().stream()
                .max((entry1,entry2) -> entry1.getValue() > entry2.getValue()?1:-1)
                .get()
                .getKey();
        System.out.println(name);
    }
}
