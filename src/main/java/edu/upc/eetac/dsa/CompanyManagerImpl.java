package edu.upc.eetac.dsa;

import jdk.jfr.Description;

import java.util.*;

public class CompanyManagerImplement implements CompanyManager{

    private HashMap<String,Company> companyMap = new HashMap<String, Company>();

    private Company searchCompany(String companyName){
        Company c = companyMap.get(companyName);
        return c;
    }

    public void addCompany(String companyName, String description){
        Company x = new Company(companyName, description);
        companyMap.put(companyName,x);
    }
    public void addEmployee(String name,String surname, String companyName, Date birthday, double salary) {
        Company c = searchCompany(companyName);
        Employee e = new Employee(name,surname,companyName,birthday,salary);
        c.setEmployeeList(e);
    }
}
