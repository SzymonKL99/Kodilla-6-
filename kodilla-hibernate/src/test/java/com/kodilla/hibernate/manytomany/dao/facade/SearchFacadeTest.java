package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.SearchFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SearchFacadeTest {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void shouldFindCompaniesByName() {
        // Given
        Company company1 = new Company("ABC Company");
        Company company2 = new Company("DEF Industries");
        Company company3 = new Company("XYZ Ltd");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        // When
        List<Company> foundCompanies = searchFacade.searchCompanyByFirstThreeCharacters("ABC");

        // Then
        assertNotNull(foundCompanies);
        assertEquals(1, foundCompanies.size());
        assertEquals("ABC Company", foundCompanies.get(0).getName());
    }

    @Test
    public void shouldFindEmployeesByLastname() {
        // Given
        Employee employee1 = new Employee("Adam", "Kowalski");
        Employee employee2 = new Employee("John", "Smith");
        Employee employee3 = new Employee("Dawid", "Klon");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        // When
        List<Employee> foundEmployees = searchFacade.searchEmployeeByLastName("Kowalski");

        // Then
        assertNotNull(foundEmployees);
        assertEquals(1, foundEmployees.size());
        assertEquals("Kowalski", foundEmployees.get(0).getLastname());

    }
    @AfterEach
    void cleanUp() {
        employeeDao.deleteAll();
        companyDao.deleteAll();
    }
}
