package com.romanyou.Employee.Asset.Management.service;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.entity.Handover;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.repository.AssetRepository;
import com.romanyou.Employee.Asset.Management.repository.EmployeeRepository;
import com.romanyou.Employee.Asset.Management.repository.HandoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HandoverServiceImpl implements HandoverService{

    @Autowired
    private HandoverRepository handoverRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;
    @Override
    public List<Handover> fetchHandoverList() {
        return handoverRepository.findAll();
    }

    @Override
    public List<Handover> fetchHandoverByEmployeeId(Long employeeId) {
        return handoverRepository.findByEmployee(employeeId);
    }

    @Override
    public List<Handover> fetchHandoverByAssetId(Long assetId) {
        return handoverRepository.findByAsset(assetId);
    }



    @Override
    public void assetHandover(Asset asset, Long employeeId) throws NotFoundException, AlreadyExistException {
//        Optional<Asset> newAsset = assetRepository.findById(asset.getAssetId());



        Optional<Employee> employee = employeeRepository.findById(employeeId);


//        if(newAsset.get().getCurrentUser()!=null){
//            Employee currentUser = newAsset.get().getCurrentUser();
//            throw new AlreadyExistException("Asset is already being used by: " + currentUser);
//        }
//        newAsset.get().setCurrentUser(employee.get());



        if(employee.isEmpty()){
            throw new NotFoundException("Employee not found!");
        }

        Date date = new Date();
        asset.setCurrentUser(employee.get());
        Handover handover = new Handover(null, employee.get(), asset, date);

        handoverRepository.save(handover);
    }


}
