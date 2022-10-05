package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.repository.AssetRepository;
import com.romanyou.Employee.Asset.Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService{

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Asset saveAsset(Asset asset) throws EmptyFieldException, AlreadyExistException {

        if(asset.getType().isBlank() || asset.getType().isEmpty() || asset.getType()=="" || asset.getType()==null){
            throw new EmptyFieldException("Type cant be empty!");
        }

        if(asset.getBrand().isBlank() || asset.getBrand().isEmpty() || asset.getBrand()=="" || asset.getBrand()==null){
            throw new EmptyFieldException("Brand cant be empty!");
        }
        if(asset.getModel().isBlank() || asset.getModel().isEmpty() || asset.getModel()=="" || asset.getModel()==null){
            throw new EmptyFieldException("Model cant be empty!");
        }
        if(asset.getSerialNumber().isBlank() || asset.getSerialNumber().isEmpty() || asset.getSerialNumber()=="" || asset.getSerialNumber()==null){
            throw new EmptyFieldException("Serial number cant be empty!");
        }

        Asset assetDB = assetRepository.findBySerialNumber(asset.getSerialNumber());

        if(assetDB!=null){
            throw new AlreadyExistException("Asset with the given Serial Number is already saved in the System. Cannot save again!");

        }


        return assetRepository.save(asset);
    }

    @Override
    public List<Asset> fetchAssetList() {
        return assetRepository.findAll();
    }

    @Override
    public Asset fetchAssetById(Long assetId) throws NotFoundException {

        Optional<Asset> asset = assetRepository.findById(assetId);

        if(!asset.isPresent()){
            throw new NotFoundException("Asset with the given ID is not founded!");
        }

        return assetRepository.findById(assetId).get();
    }

    @Override
    public void deleteAssetById(Long assetId) {
        assetRepository.deleteById(assetId);
    }

    @Override
    public Asset updateAsset(Long assetId, Asset asset) throws NotFoundException {
        Optional<Asset> assetDB = assetRepository.findById(assetId);

        if(!assetDB.isPresent()){
            throw new NotFoundException("Asset with the given ID is not founded!");
        }



        if(Objects.nonNull(asset.getBrand()) && !"".equalsIgnoreCase(asset.getBrand())){
            assetDB.get().setBrand(asset.getBrand());
        }

        if(Objects.nonNull(asset.getModel()) && !"".equalsIgnoreCase(asset.getModel())){
            assetDB.get().setModel(asset.getModel());
        }

        if(Objects.nonNull(asset.getType()) && !"".equalsIgnoreCase(asset.getType())){
            assetDB.get().setType(asset.getType());
        }

        if(Objects.nonNull(asset.getSerialNumber()) && !"".equalsIgnoreCase(asset.getSerialNumber())){
            assetDB.get().setSerialNumber(asset.getSerialNumber());
        }

        return assetRepository.save(assetDB.get());
    }

    @Override
    public Asset findAssetBySerialNumber(String serialNumber) {
       return assetRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<Asset> fetchAssetListByBrand(String brand) {
        return assetRepository.findByBrand(brand);
    }

    @Override
    public List<Asset> fetchAssetsByEmployee(long employeeId) {
        Employee dbEmp = employeeRepository.findByEmployeeId(employeeId);
        return assetRepository.findByCurrentUser(dbEmp);
    }
}
