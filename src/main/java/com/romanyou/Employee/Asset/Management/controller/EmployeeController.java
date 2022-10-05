package com.romanyou.Employee.Asset.Management.controller;

import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.repository.EmployeeRepository;
import com.romanyou.Employee.Asset.Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
/**
 * @Author Roman Behroz 571708
 * Web Development Final Project
 * Controller for Employee Table for fetching, updating or deleting the Data
 */
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path = {"/employees"}, produces = APPLICATION_JSON_VALUE)
    public Employee saveEmployee(@RequestBody Employee employee) throws AlreadyExistException, EmptyFieldException {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }


    @GetMapping("/employees/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable("email") String email) throws NotFoundException {
        return employeeService.getEmployeeByEmail(email);
    }

    @GetMapping("/employees/firstname/{firstName}")
    public List<Employee> getEmployeeListByFirstName(@PathVariable("firstName") String firstName){
        return employeeService.getEmployeeListByFirstName(firstName);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId) throws NotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }


    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) throws NotFoundException, AlreadyExistException {
        return employeeService.updateEmployee(employeeId, employee);
    }


    @DeleteMapping("/employees/{employeeId}")
    public boolean deleteEmployee(@PathVariable("employeeId") Long employeeId) throws NotFoundException {
        return employeeService.deleteEmployee(employeeId);
    }


    @GetMapping("/employees/latest")
    public List<Employee> latestEmployees(){
       return employeeRepository.findLast5Employees();
    }




}
