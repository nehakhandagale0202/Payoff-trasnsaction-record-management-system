package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.CustEntity;

public interface cService {
    
    public CustEntity AddORUpdate(CustEntity cust);

    public List<CustEntity> getAll();

    public CustEntity getById(int id);

    public CustEntity delete(int id) throws Exception;

    public CustEntity update(int id, CustEntity myResource) throws Exception;
}
