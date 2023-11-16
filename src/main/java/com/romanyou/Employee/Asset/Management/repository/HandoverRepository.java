package com.romanyou.Employee.Asset.Management.repository;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.entity.Handover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Roman Behroz
 * Respository for Handover Table
 */
@Repository
public interface HandoverRepository extends JpaRepository<Handover, Long> {

    /**
     * Finds handovers for the given employee id
     * @param employeeId employee id
     * @return list of Handovers
     */
    @Query(nativeQuery = true, value = "SELECT * FROM handover h WHERE h.employee_id = ?1")
    List<Handover> findByEmployee(Long employeeId);


    /**
     * finds Handovers by Asset id
     * @param assetId asset id
     * @return list of Handovers
     */
    @Query(nativeQuery = true, value = "SELECT * FROM handover h WHERE h.asset_id = ?1")
    List<Handover> findByAsset(Long assetId);


    /**
     * inserst record in to the Handover Table
     * @param assetId
     * @param employeeId
     * @param date
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO handover (handover_id, asset_id, employee_id, handover_date) VALUES(null, ?1, ?2, ?3)")
    void assign(Long assetId, Long employeeId, Date date);


    /**
     * finds 3 latest handovers
     * @return list of handovers
     */
    @Query(nativeQuery = true, value = "SELECT * FROM handover ORDER BY handover_id DESC LIMIT 3")
    List<Handover> findLast5Handovers();
}
