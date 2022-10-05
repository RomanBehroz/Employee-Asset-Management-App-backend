package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.entity.Return;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.repository.AssetRepository;
import com.romanyou.Employee.Asset.Management.repository.EmployeeRepository;
import com.romanyou.Employee.Asset.Management.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReturnServiceImpl implements ReturnService{

    @Autowired
    private ReturnRepository returnRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Return> fetchReturnList() {
        return returnRepository.findAll();
    }

    @Override
    public String assetReturn(Asset asset, Long employeeId) throws NotFoundException, EmptyFieldException {

        Optional<Asset> assetDB = assetRepository.findById(asset.getAssetId());
        Optional<Employee> employeeDB = employeeRepository.findById(employeeId);

        if(!assetDB.isPresent()){
            throw new NotFoundException("Asset with the given ID Not Found!");
        }

        if(!employeeDB.isPresent()){
            throw new NotFoundException("Employee with the given ID Not Found!");
        }

        if(assetDB.get().getCurrentUser() == null){
            throw new EmptyFieldException("Asset is not assigned to anyone!");
        }else if(assetDB.get().getCurrentUser().getEmployeeId()!=employeeId){
            throw new NotFoundException("Asset with the given ID is not assigned to the Employee with the given ID");
        }else{
            Return returnAsset = new Return();
            returnAsset.setAsset(assetDB.get());
            returnAsset.setEmployee(employeeDB.get());
            returnAsset.setReturnDate(new Date());
            returnRepository.save(returnAsset);

            assetDB.get().setCurrentUser(null);

            assetRepository.save(assetDB.get());
        }

        return "Asset Returned Successfully!";
    }

    @Override
    public List<Return> fetchReturnListByEmployee(Long employeeId) throws NotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(!employee.isPresent()){
            throw new NotFoundException("Employee with the given ID Not Founded!");
        }

        return returnRepository.findAllByEmployee(employee.get());
    }
}
