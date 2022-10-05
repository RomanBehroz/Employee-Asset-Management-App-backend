package com.romanyou.Employee.Asset.Management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Author Roman Behroz
 * Table to hold Handover information/records
 */
public class Handover {

    @Id
    @SequenceGenerator(name = "handover_sequence", sequenceName = "handover_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "handover_sequence")
    private Long handoverId;


    /**
     * The employee who received the Asset
     */
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    /**
     * The Asset which is given to the Employee
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;


    /**
     * The Date of the Handover
     */
    private Date handoverDate;

}
