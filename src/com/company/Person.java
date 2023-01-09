package com.company;

public class Person{
   String name;
   String surname;
   int age;
   Group group;

   public Person(Group group, String name, String surname, int age) {

       this.group
               = group;
       group.add(this);

       this.name
               = name;
       this.surname = surname;
       this.age = age;
   }

   public Person(String name, String surname) {

       this.name
               = name;
       this.surname = surname;
   }

   public Person() {

   }

   public String getName() {
       return name;
   }

   public String getSurname() {
       return surname;
   }

   public int getAge() {
       return age;
   }

   public Group getGroup() {
       return group;
   }

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name + '\'' +
                 ", surname='" + surname + '\'' +
                 ", age=" + age +
                 ", group=" + group +
                 '}';
     }
 }
