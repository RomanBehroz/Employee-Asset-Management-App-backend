package com.romanyou.Employee.Asset.Management.controller;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
/**
 * @Author Roman Behroz 571708
 * Web Development Final Project
 * Controller for Asset Table for fetching, updating or deleting the Data
 */
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping("/assets")
    public Asset saveAsset(@RequestBody Asset asset) throws EmptyFieldException, AlreadyExistException {
        return assetService.saveAsset(asset);
    }

    @GetMapping("/assets")
    public List<Asset> fetchAssetList(){
        return assetService.fetchAssetList();
    }

    @GetMapping("/assets/brand/{brand}")
    public List<Asset> fetchAssetListByBrand(@PathVariable("brand") String brand){
        return assetService.fetchAssetListByBrand(brand);
    }

    @GetMapping("/assets/{id}")
    public Asset fetchAssetById(@PathVariable("id") Long assetId) throws NotFoundException {
        return assetService.fetchAssetById(assetId);
    }

    @GetMapping("/assets/emp/{employeeId}")
    public List<Asset> fetchAssetsByEmployee(@PathVariable("employeeId") long employeeId){
        return assetService.fetchAssetsByEmployee(employeeId);
    }

    @DeleteMapping("/assets/{id}")
    public String deleteAssetById(@PathVariable("id") Long assetId){

        assetService.deleteAssetById(assetId);
        return "Asset deleted successfully!";
    }

    @PutMapping("/assets/{id}")
    public Asset updateAsset(@PathVariable("id") Long assetId, @RequestBody Asset asset) throws NotFoundException {
        return assetService.updateAsset(assetId, asset);
    }

    @GetMapping("/assets/sn/{serialNumber}")
    public Asset findAssetBySerialNumber(@PathVariable("serialNumber") String serialNumber){
        return assetService.findAssetBySerialNumber(serialNumber);
    }
}
