package com.romanyou.Employee.Asset.Management.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Author Roman Behroz
 * Represents an Asset = a Device e.g. Laptop, or Mobile
 */
public class Asset {

    @Id
    @SequenceGenerator(name = "asset_sequence", sequenceName = "asset_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_sequence")
    private Long assetId;

    /**
     * Asset Type e.g. Laptop
     */
    private String type;

    /**
     * Asset Brand e.g. Apple
     */
    private String brand;

    /**
     * Asset Model e.g. Iphone 12
     */
    private String model;


    /**
     * Asset Serial number e.g. FKLJSD982
     */
    private String serialNumber;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "employeeId"
    )
    /**
     * The Employee who is currently using this Asset/Device
     */
    private Employee currentUser;


}
