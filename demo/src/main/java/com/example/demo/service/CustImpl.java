package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustEntity;
import com.example.demo.repo.custRepo;



@Service
public class CustImpl implements cService{
    @Autowired
    private custRepo cRepo;

    @Override
    public CustEntity AddORUpdate(CustEntity cust) {
        return cRepo.save(cust);
    }

    @Override
    public List<CustEntity> getAll() {
       return (List<CustEntity>) cRepo.findAll();
    }

    @Override
    public CustEntity getById(int id) {
        return cRepo.findById(id).orElse(null);
    }

    @Override
    public CustEntity delete(int id) throws Exception
    {
        CustEntity deletedC=null;
        try{
            deletedC=cRepo.findById(id).orElse(null);
            if(deletedC==null){
                throw new Exception("Customer not available");
            }else{
                cRepo.deleteById(id);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
        return deletedC ;
    }

    @Override
    public CustEntity update(int id, CustEntity myResource) throws Exception{        
      
       CustEntity updateC=cRepo.findById(id).orElse(null);
       try{
        if(updateC == null){
            throw new Exception("user not available");
        }else{
            updateC.setName(myResource.getName());
            updateC.setMob(myResource.getMob());
            updateC.setAdd(myResource.getAdd());
            updateC.setCity(myResource.getCity());
            System.out.println("chetan" + myResource.getName());

            updateC = cRepo.save(updateC);
            return updateC;
        }
       }catch(Exception ex){
        System.out.println(ex.getMessage());
        throw ex;
       }        
    //    return updateEmp;
    }
}