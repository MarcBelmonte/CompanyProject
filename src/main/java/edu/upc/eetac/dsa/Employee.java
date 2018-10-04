package edu.upc.eetac.dsa;

import java.util.Date;

public class Employee implements Comparable<Employee>{
    //Atributos
    String name, surname,companyName;
    Date birthday;
    double salary;

    //Constructor


    public Employee(String name, String surname, String companyName, Date birthday, double salary) {
        this.name = name;
        this.surname = surname;
        this.companyName = companyName;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }

    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
