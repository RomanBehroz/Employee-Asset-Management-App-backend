package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) throws AlreadyExistException, EmptyFieldException {

        Employee empDB = employeeRepository.findByEmail(employee.getEmail());

        if(empDB != null ){
            throw new AlreadyExistException("Employee with the given Email is already registered in the system!");
        }

        if(employee.getFirstName().isBlank() || employee.getFirstName().isEmpty() || employee.getFirstName()=="" || employee.getFirstName()==null){
            throw new EmptyFieldException("First name cant be empty!");
        }

        if(employee.getLastName().isBlank() || employee.getLastName().isEmpty() || employee.getLastName()=="" || employee.getLastName()==null){
            throw new EmptyFieldException("Last name cant be empty!");
        }
        if(employee.getEmail().isBlank() || employee.getEmail().isEmpty() || employee.getEmail()=="" || employee.getEmail()==null){
            throw new EmptyFieldException("Email cant be empty!");
        }


        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmail(String email) throws NotFoundException {

        Employee empDB = employeeRepository.findByEmail(email);

        if(empDB == null || empDB.equals(null)){
            throw new NotFoundException("Employee with the given Email is not founded!");
        }

        return empDB;
    }

    @Override
    public List<Employee> getEmployeeListByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws NotFoundException {
        Employee empDB = employeeRepository.findByEmployeeId(employeeId);

        if(empDB == null){
            throw new NotFoundException("Employee with the given ID is not founded!");
        }

        return empDB;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) throws NotFoundException, AlreadyExistException {
        Optional<Employee> employeeDB = employeeRepository.findById(employeeId);

        if(!employeeDB.isPresent()){
            throw new NotFoundException("Employee with the given ID is not founded!");
        }


        Employee employeeEmail = employeeRepository.findByEmail(employee.getEmail());

        if(employeeEmail !=null && !employee.getEmail().equals(employeeDB.get().getEmail())){
            throw new AlreadyExistException("Given Email is already registered!");
        }

        if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee
                .getFirstName())){
            employeeDB.get().setFirstName(employee.getFirstName());
        }

        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee
                .getLastName())){
            employeeDB.get().setLastName(employee.getLastName());
        }

        if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            employeeDB.get().setEmail(employee.getEmail());
        }

        if(Objects.nonNull(employee.getTitle()) && !"".equalsIgnoreCase(employee.getTitle())){
            employeeDB.get().setTitle(employee.getTitle());
        }


        return employeeRepository.save(employeeDB.get());
    }

    @Override
    public boolean deleteEmployee(Long employeeId) throws NotFoundException {
        Optional<Employee> empDB = employeeRepository.findById(employeeId);

        if(!empDB.isPresent()){
            throw new NotFoundException("Employee with the given ID" + employeeId + " not found!");
        }

        employeeRepository.deleteById(employeeId);

        return true;
    }

    @Override
    public int getNumberOfTotalEmployees() {

        return employeeRepository.findAll().size();
    }


}
