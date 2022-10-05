package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;

import java.util.List;

/**
 * @Author Roman Behroz 571708
 * Asset Service Page to insert, patch, update or delete data
 * Web development final project
 */
public interface AssetService {
    /**
     * Saves an Asset to the System
     * @param asset the asset
     * @return the asset
     * @throws EmptyFieldException if any fields are left blank
     * @throws AlreadyExistException if Assets already exists
     */
    Asset saveAsset(Asset asset) throws EmptyFieldException, AlreadyExistException;

    /**
     * Fetches list of all Assets
     * @return
     */
    List<Asset> fetchAssetList();

    /**
     * Fetches Asset by its Id
     * @param assetId asset id
     * @return the asset
     * @throws NotFoundException if asset is not found
     */
    Asset fetchAssetById(Long assetId) throws NotFoundException;

    /**
     * deletes and Asset by its id
     * @param assetId asset id
     */
    void deleteAssetById(Long assetId);

    /**
     * updates/patches an Asset
     * @param assetId Asset id
     * @param asset new Asset with new values
     * @return the Asset saved
     * @throws NotFoundException if Asset is not found
     */
    Asset updateAsset(Long assetId, Asset asset) throws NotFoundException;

    /**
     * finds the Asset by its serial number
     * @param serialNumber serial number of asset
     * @return the asset
     */
    Asset findAssetBySerialNumber(String serialNumber);

    /**
     * List of Assets by the same Brand name
     * @param brand
     * @return
     */
    List<Asset> fetchAssetListByBrand(String brand);

    /**
     * Fetches Assets list by the given employee id
     * @param employeeId id of the employee
     * @return list of assets
     */
    List<Asset> fetchAssetsByEmployee(long employeeId);
}
