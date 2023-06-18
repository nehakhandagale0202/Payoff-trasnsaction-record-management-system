package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CustEntity;

 

public interface custRepo extends CrudRepository <CustEntity, Integer>
{
    
}