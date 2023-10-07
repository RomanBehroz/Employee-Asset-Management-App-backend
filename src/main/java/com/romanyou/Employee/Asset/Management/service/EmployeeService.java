package com.romanyou.Employee.Asset.Management.service;


import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;

import java.util.List;

/**
 * @Author Roman Behroz
 * Service Page for Employee to insert, update, patch or delete Data
 */
public interface EmployeeService {
    /**
     * Saves an Employee to the Database
     * @param employee the employee
     * @return the saved employee
     * @throws AlreadyExistException if employee already exists
     * @throws EmptyFieldException if any fields are left blank
     */
    Employee saveEmployee(Employee employee) throws AlreadyExistException, EmptyFieldException;

    /**
     * fetch the list of employees
     * @return employee list
     */
    List<Employee> getEmployeeList();

    /**
     * fetches an employee by email
     * @param email given email
     * @return the employee
     * @throws NotFoundException if employee not found
     */
    Employee getEmployeeByEmail(String email) throws NotFoundException;

    /**
     * fetch list of employees by the same first name
     * @param firstName first name
     * @return list of employees
     */
    List<Employee> getEmployeeListByFirstName(String firstName);

    /**
     * fetch an employee by its id
     * @param employeeId emp id
     * @return the employee
     * @throws NotFoundException if not founded
     */
    Employee getEmployeeById(Long employeeId) throws NotFoundException;

    /**
     * updates / patches an employee
     * @param employeeId the employee to be updated
     * @param employee new values
     * @return saved employee
     * @throws NotFoundException if not founded
     * @throws AlreadyExistException if email already exists
     */
    Employee updateEmployee(Long employeeId, Employee employee) throws NotFoundException, AlreadyExistException;

    /**
     * deletes an employee from the database
     * @param employeeId id of employee to delete
     * @return true when deleted
     * @throws NotFoundException if not founded
     */
    boolean deleteEmployee(Long employeeId) throws NotFoundException;


    int getNumberOfTotalEmployees();
}
