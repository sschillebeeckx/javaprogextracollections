package be.abis.acca.model;

import be.abis.acca.exception.AgeException;
import be.abis.acca.exception.PersonShouldBeAdultException;
import be.abis.acca.exception.PersonShouldNotBeRetiredException;

import java.util.Comparator;

public class Person implements Comparable<Person>{

    private static int personCounter;
    private int personNumber;
    private String firstName;
    private String lastName;
    private int age;
    private Company company;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        personNumber=++personCounter;
    }

    public Person(String firstName, String lastName, int age, Company company) {
        this(firstName, lastName, age);
        this.company = company;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int calculateAge() throws AgeException {
        if (age<18) throw new PersonShouldBeAdultException("You are too young");
        if (age>67) throw new PersonShouldNotBeRetiredException("You should be enjoying life");
        return age;
    }

    public String toString(){
        return "Person " + personNumber + ", " +firstName + " " + lastName + ", is " + age + " years old.";
    }

    public void printInfo(){
        Company c = this.company;
        System.out.println("Person " + personNumber + ": " + firstName + " " + lastName + " (" + age + " years old)" + ((c!=null)?" works for " + c.getName() + " in " + c.getAddress().getTown() +".":" is not employed for the moment."));
    }

    @Override
    public int compareTo(Person o) {
        return this.personNumber-o.personNumber;
    }

    public static class AgeComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.age-o2.age;
        }
    }

    public static class FirstNameComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.firstName.compareTo(o2.firstName);
        }
    }
}
