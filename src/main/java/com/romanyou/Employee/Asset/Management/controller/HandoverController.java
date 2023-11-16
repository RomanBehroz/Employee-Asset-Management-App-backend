package com.romanyou.Employee.Asset.Management.controller;

import com.romanyou.Employee.Asset.Management.entity.Asset;
import com.romanyou.Employee.Asset.Management.entity.Handover;
import com.romanyou.Employee.Asset.Management.exception.AlreadyExistException;
import com.romanyou.Employee.Asset.Management.exception.EmptyFieldException;
import com.romanyou.Employee.Asset.Management.exception.NotFoundException;

import com.romanyou.Employee.Asset.Management.repository.HandoverRepository;
import com.romanyou.Employee.Asset.Management.service.AssetService;
import com.romanyou.Employee.Asset.Management.service.HandoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
/**
 * @Author Roman Behroz 571708
 * Web Development Final Project
 * Controller for Handover Table for fetching, updating or deleting the Data
 */
public class HandoverController {


    @Autowired
    private HandoverService handoverService;

    @Autowired
    private AssetService assetService;

    @Autowired
    private HandoverRepository handoverRepository;


    @GetMapping("/handover")
    public List<Handover> fetchHandoverList(){
        return handoverService.fetchHandoverList();
    }


    @GetMapping("handover/emp/{employeeId}")
    public List<Handover> fetchHandoverByEmployeeId(@PathVariable("employeeId") Long employeeId){
        return handoverService.fetchHandoverByEmployeeId(employeeId);
    }

    @GetMapping("handover/asset/{assetId}")
    public List<Handover> fetchHandoverByAssetId(@PathVariable("assetId") Long assetId){
        return handoverService.fetchHandoverByAssetId(assetId);
    }


    @PostMapping("/handover/add/{employeeId}")
    public String saveNewAssetAndHandover(@RequestBody Asset asset, @PathVariable("employeeId") Long employeeId) throws AlreadyExistException, EmptyFieldException, NotFoundException {

        Asset newAsset = assetService.saveAsset(asset);
        handoverService.assetHandover(newAsset, employeeId);

        return "Added Successfully!";
    }


    @PostMapping("/handover/assign/{employeeId}")
    public String assetHandover(@RequestBody Asset asset, @PathVariable("employeeId") Long employeeId) throws NotFoundException, AlreadyExistException {

        handoverService.assetHandover(asset, employeeId);

        return"Assigned Succesfully!";
    }

    @GetMapping("/handover/latest")
    public List<Handover> latestHandovers(){
        return handoverRepository.findLast5Handovers();
    }

}
