package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Handover;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;

import java.util.List;

/**
 * @Author ROman Behroz
 * Service page for Handover to insert, update, patch or delete Data
 */
public interface HandoverService {

    /**
     * fetches list of handovers
     * @return
     */
    List<Handover> fetchHandoverList();


    /**
     * fetches handovers by the given employee id
     * @param employeeId emp id
     * @return list of handovers
     */
    List<Handover> fetchHandoverByEmployeeId(Long employeeId);

    /**
     * fetches handovers by the given asset id
     * @param assetId asset id
     * @return list of handovers
     */
    List<Handover> fetchHandoverByAssetId(Long assetId);


    /**
     * handovers an asset to an employee
     * @param asset asset to to hand over
     * @param employeeId the employee who receives the asset
     * @throws NotFoundException if asset or employee is not founded
     * @throws AlreadyExistException if asset already exists in system cant be added again
     */
    void assetHandover(Asset asset, Long employeeId) throws NotFoundException, AlreadyExistException;
}
