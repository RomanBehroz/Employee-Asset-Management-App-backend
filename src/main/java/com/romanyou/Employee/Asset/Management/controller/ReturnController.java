package com.romanyou.Employee.Asset.Management.controller;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Employee;
import com.romanyou.Employee.Asset.Management.entity.Handover;
import com.romanyou.Employee.Asset.Management.entity.Return;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;
import com.romanyou.Employee.Asset.Management.repository.AssetRepository;
import com.romanyou.Employee.Asset.Management.repository.ReturnRepository;
import com.romanyou.Employee.Asset.Management.service.AssetService;
import com.romanyou.Employee.Asset.Management.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
/**
 * @Author Roman Behroz 571708
 * Web Development Final Project
 * Controller for Return Table for fetching, updating or deleting the Data
 */
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @Autowired
    private AssetService assetService;


    @Autowired
    private ReturnRepository returnRepository;

    @GetMapping("/return")
    public List<Return> fetchReturnList(){
        return returnService.fetchReturnList();
    }


    @PostMapping("/return/asset/{employeeId}")
    public String assetReturn (@RequestBody Asset asset, @PathVariable("employeeId") Long employeeId) throws NotFoundException, EmptyFieldException {
        return returnService.assetReturn(asset, employeeId);
    }

    @GetMapping("/return/list/{employeeId}")
    public List<Return> fetchReturnListByEmployee(@PathVariable("employeeId") Long employeeId) throws NotFoundException {
        return returnService.fetchReturnListByEmployee(employeeId);
    }

    @GetMapping("/return/latest")
    public List<Return> latestReturns(){
        return returnRepository.findLast5Returns();
    }
}
