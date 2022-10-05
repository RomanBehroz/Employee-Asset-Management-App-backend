package com.romanyou.Employee.Asset.Management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Author Roman Behroz
 * Return Table holds records/information about devices/assets that are returned back by the employees
 */
public class Return {

    @Id
    @SequenceGenerator(name = "return_sequence", sequenceName = "return_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "return_sequence")
    private Long returnId;

    /**
     * Employee who returned the Asset
     */
    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    /**
     * The Asset which returned
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    /**
     * Date of return
     */
    private Date returnDate;
}
