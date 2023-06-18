package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustEntity;
import com.example.demo.service.cService;



@RestController
@RequestMapping("customer")
public class CustController {
 
    @Autowired
    private cService custS;
    
    @PostMapping("AddOrUpdate")
    public ResponseEntity<CustEntity> AddOrUpdate(@RequestBody CustEntity cust){
        CustEntity cust2 = null;
         try{
            cust2=custS.AddORUpdate(cust);
         }catch(Exception ex){
            ex.getMessage();
         }
        return new ResponseEntity<CustEntity>(cust2, HttpStatus.OK);
    }

    @GetMapping("allCustomer")
    public ResponseEntity<List<CustEntity>> getAll(){
        List<CustEntity> cust=null;
        try{
            cust=custS.getAll();
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<CustEntity>>(cust,HttpStatus.OK);
    }


    @GetMapping("getById/{id}")
    public ResponseEntity<CustEntity> getById(@PathVariable("id")int id){
        CustEntity cust = null;
        try{
            cust=custS.getById(id);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<CustEntity>(cust, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<CustEntity> delete(@PathVariable("id") int id)
    {
        CustEntity cust=null;
        try{
            cust=custS.delete(id);
        }catch(Exception ex)
        {
            ex.getMessage();
        }
        return new ResponseEntity<CustEntity>(cust, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CustEntity> update(@PathVariable("id")int id, @RequestBody CustEntity myResource)
    {
        CustEntity cust=null;
        try{
            cust=custS.update(id, myResource);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<CustEntity>(cust,HttpStatus.OK);
    }
}