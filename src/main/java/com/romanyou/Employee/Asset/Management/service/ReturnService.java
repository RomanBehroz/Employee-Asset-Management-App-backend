package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Return;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;

import java.util.List;

/**
 * @Author ROman Behroz
 * Service page for Return to insert update patch or delete Data
 */
public interface ReturnService {

    /**
     * fetches list of Returns
     * @return
     */
    List<Return> fetchReturnList();

    /**
     * Returns an Asset
     * @param asset the asset which is returned
     * @param employeeId the employee who returned the Asset
     * @return succes or fail message
     * @throws NotFoundException if asset or employee is not founded
     * @throws EmptyFieldException if any of needed fields are left blank
     */
    String assetReturn(Asset asset, Long employeeId) throws NotFoundException, EmptyFieldException;

    /**
     * Fetches Returns by employee
     * @param employeeId employee id to look for
     * @return list of returns
     * @throws NotFoundException if asset is not founded
     */
    List<Return> fetchReturnListByEmployee(Long employeeId) throws NotFoundException;
}
