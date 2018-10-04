package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CompanyManagerImplTest {

    final static Logger log = Logger.getLogger(CompanyManagerImplTest.class.getName());
    private CompanyManager cm;

    @Before
    public void setUp() throws MyException {
        this.cm = new CompanyManagerImpl();

        this.cm.addCompany("Google","Page");
        this.cm.addCompany("Amazon","Bezos");
        this.cm.addCompany("Apple","Jobs");

        try{
            this.cm.addEmployee("Marc","Velmont",null,1500.00,"Amazon");
            this.cm.addEmployee("Sonia","Gonzalez",null,1650,"Amazon");
            this.cm.addEmployee("Izan","Peace",null,1200,"Apple");
            this.cm.addEmployee("Enzo","Williams",null,1060,"Google");
            this.cm.addEmployee("Alex","Vask",null,288,"Euskatel");


        }
        catch(MyException e){
            log.warn("This company doesn't exist.");
        }
    }

    @After
    public void tearDown() throws MyException {
        this.cm = null;
    }

    @Test
    public void addEmployee() {
        try {
            this.cm.addEmployee("Mary", "Stevenson", null, 1900, "Google");
            this.cm.addEmployee("Peter", "Parkinson", null, 1288, "Apple");
            this.cm.addEmployee("Henry", "Cubes", null, 1400, "Amazon");
            this.cm.addEmployee("Adolfo", "Rigoberto", null, 0, "Avantia");
            this.cm.addEmployee("Susan","August",null, 9000, "Amazon");

            List<Employee> employeeList = this.cm.employees("Amazon");

            assertEquals(employeeList.get(0).getName(), "Marc");
            assertEquals(employeeList.get(1).getName(), "Sonia");
            assertEquals(employeeList.get(2).getName(), "Izan");

            employeeList = this.cm.employees("Google");

            assertEquals(employeeList.get(0).getName(), "Enzo");
            assertEquals(employeeList.get(1).getName(), "Peter");
            assertEquals(employeeList.get(2).getName(), "Alberto");
            }
            catch (MyException e){
                log.warn("Employee doesn't exist in this company");
            }

    }

    @Test
    public void findAllEmployeesOrderedByName() {
        List<Employee> employeesSorted = this.cm.findAllEmployeesOrderedByName();

        assertEquals(employeesSorted.get(0).name,"Henry");
        assertEquals(employeesSorted.get(1).name,"Marc");
        assertEquals(employeesSorted.get(2).name,"Sonia");
        assertEquals(employeesSorted.get(3).name,"Susan");
    }

    @Test
    public void findAllEmployeesOrderedBySalary() {
        List<Employee> employeesSorted = this.cm.findAllEmployeesOrderedBySalary();

        assertEquals(employeesSorted.get(0).salary,1400,0);
        assertEquals(employeesSorted.get(1).salary,1500,0);
        assertEquals(employeesSorted.get(2).salary,1650,0);
        assertEquals(employeesSorted.get(3).salary,9000,0);


    }

    /*@Test
   public void employees() {
        try {
            List<Employee> e = this.cm.employees("Apple");

            assertEquals(e.get(0).name, "Izan");
            assertEquals(e.get(1).name, "Peter");
        }
        catch(MyException e){
            log.warn("This company doesn't have those employees");

        }
    }  */

    @Test
    public void findAllCompanies(){
        List<Company>  companies = this.cm.findAllCompanies();

        assertEquals(companies.get(0).companyName,"Google");
        assertEquals(companies.get(1).companyName, "Amazon");
        assertEquals(companies.get(2).companyName, "Apple");


    }
}