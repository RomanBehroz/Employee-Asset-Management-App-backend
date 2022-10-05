package com.romanyou.Employee.Asset.Management.repository;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.entity.Handover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Roman Behroz
 * Web Development Final Project
 * Repository for Asset Table
 */
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    /**
     * Finds Assets by their Brand name
     * @param brand brand of the Asset
     * @return list of Assets
     */
    List<Asset> findByBrand(String brand);

    /**
     * finds an Asset by its Serial number
     * @param serialNumber serial number of the Asset
     * @return the Asset
     */
    Asset findBySerialNumber(String serialNumber);

    List<Asset> findByCurrentUser(Employee currentUser);

}
