package com.romanyou.Employee.Asset.Management.repository;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Employee Table
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Finds Employees by their first name
     * @param firstName employee firstname
     * @return list of employees
     */
    List<Employee> findByFirstName(String firstName);


    /**
     * finds the employee by its id
     * @param employeeId employee id
     * @return the employee
     */
    Employee findByEmployeeId(Long employeeId);

    /**
     * finds an employee by its email address
     * @param email email of employee
     * @return the employee
     */
    Employee findByEmail(String email);


    /**
     * finds 3 latest employees inserted in the system
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT * FROM employee ORDER BY employee_id DESC LIMIT 3")
    List<Employee> findLast5Employees();

}
