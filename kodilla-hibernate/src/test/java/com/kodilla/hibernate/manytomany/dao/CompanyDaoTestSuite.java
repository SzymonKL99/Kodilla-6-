package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

        @Test
        void testSaveManyToMany() {
            //Given
            Employee adamKowalski = new Employee("Adam", "Kowalski");
            Employee johnSmith = new Employee("John", "Smith");
            Employee dawidKlon = new Employee("Dawid", "Klon");

            Company boshCompany = new Company("Bosh");
            Company lgCompany = new Company("LG");
            Company teslaCompany = new Company("Tesla");

            boshCompany.getEmployees().add(adamKowalski);
            lgCompany.getEmployees().add(johnSmith);
            lgCompany.getEmployees().add(dawidKlon);
            teslaCompany.getEmployees().add(adamKowalski);
            teslaCompany.getEmployees().add(dawidKlon);

            adamKowalski.getCompanies().add(boshCompany);
            adamKowalski.getCompanies().add(teslaCompany);
            johnSmith.getCompanies().add(lgCompany);
            dawidKlon.getCompanies().add(lgCompany);
            dawidKlon.getCompanies().add(teslaCompany);

            // When
            companyDao.save(boshCompany);
            int boshCompanyId = boshCompany.getId();
            companyDao.save(lgCompany);
            int lgCompanyId = lgCompany.getId();
            companyDao.save(teslaCompany);
            int teslaCompanyId = teslaCompany.getId();

            // Then
            assertNotEquals(0, boshCompanyId);
            assertNotEquals(0, lgCompanyId);
            assertNotEquals(0, teslaCompanyId);
        }
    @Test
    public void testFindByFirstThreeCharacters() {
        Company company1 = new Company("ABC Company");
        Company company2 = new Company("DEF Corporation");
        Company company3 = new Company("XYZ Ltd");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        List<Company> foundCompanies = companyDao.findByFirstThreeCharacters("ABC");

        Assertions.assertEquals(1, foundCompanies.size());

        Assertions.assertEquals("ABC Company", foundCompanies.get(0).getName());
    }


    @Test
    void testNamedQueries() {
        // Given
        Employee employee1 = new Employee("Adam", "Kowalski");
        Employee employee2 = new Employee("John", "Smith");
        Employee employee3 = new Employee("Dawid", "Klon");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        // When
        List<Employee> employeesWithLastnameDoe = employeeDao.findByLastname("Kowalski");

        // Then
        try {
            Assertions.assertEquals(1, employeesWithLastnameDoe.size());
            Assertions.assertEquals("Kowalski", employeesWithLastnameDoe.get(0).getLastname());

        } finally {
            // CleanUp
            employeeDao.deleteAll();
        }
    }
    @AfterEach
    void cleanUp() {
        employeeDao.deleteAll();
        companyDao.deleteAll();
    }

}