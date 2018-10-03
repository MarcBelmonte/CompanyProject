package edu.upc.eetac.dsa;

import java.util.LinkedList;
import java.util.*;

public class Company{
    String companyName,description;
    LinkedList<Employee> employeeList;

    public LinkedList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployeeList( Employee employee) {
        this.employeeList.add(employee);
    }

    public Company(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
        this.employeeList = new LinkedList<Employee>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setName(String name) {
        this.companyName = companyName;
    }

}
