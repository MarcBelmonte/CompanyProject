package edu.upc.eetac.dsa;

import jdk.jfr.Description;
import java.util.*;
import java.lang.*;

public class CompanyManagerImpl implements CompanyManager{

    private HashMap<String,Company> companyMap = new HashMap<String, Company>();

   //
    //private LinkedList<Company> companyList = new LinkedList<Company>();
    private List<Employee> employees = new LinkedList<Employee>();


    private Company searchCompany(String companyName){
        Company c = companyMap.get(companyName);
        return c;
    }

    public void addCompany(String companyName, String description){
        Company x = new Company(companyName, description);
        companyMap.put(companyName,x);
      //  companyList.add(x);

    }
    public void addEmployee(String name,String surname, Date birthday, double salary, String companyName) throws  MyException {
        Company c = searchCompany(companyName);
        Employee e = new Employee(name,surname,companyName,birthday,salary);
        if (c!=null) {
            c.addEmployeeList(e);
        }
        else {
            // log.warn();
            throw new MyException();
        }

    }
    public List<Employee> findAllEmployeesOrderedByName(){

        Collections.sort(this.employees);
        return this.employees;
    }
    public List<Employee> findAllEmployeesOrderedBySalary(){
        Collections.sort(this.employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (int)(o1.getSalary()-o2.getSalary());
            }
        });
        return this.employees;

    }
    public List<Employee> employees(String company){
      Company c = searchCompany(company);
      return (c==null?null:c.getEmployeeList());
    }
    public List<Company> findAllCompanies() {
      return (List<Company>)this.companyMap.values();
    }
}
