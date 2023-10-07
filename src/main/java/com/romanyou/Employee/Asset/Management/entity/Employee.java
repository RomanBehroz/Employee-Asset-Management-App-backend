package com.romanyou.Employee.Asset.Management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * @Author Roman Behroz
 * Represents and Employee
 */
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_sequence")
    private Long employeeId;

    /**
     * First name of the employee
     */
    @NotBlank(message = "Please add first name!")
    private String firstName;

    /**
     * last name of the employee
     */
    @NotBlank(message = "Please add last name!")
    private String lastName;

    /**
     * email of the employee
     */
    private String email;

    /**
     * job title of the employee
     */
    private String title;
  
}
