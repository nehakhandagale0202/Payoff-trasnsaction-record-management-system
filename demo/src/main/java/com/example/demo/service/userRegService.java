package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.userRegister;

public interface userRegService {
    public userRegister AddORUpdate(userRegister user);

    public List<userRegister> getAll();

    public userRegister getbyID(Long id);    

    public userRegister delete(Long id) throws Exception;

    public userRegister update(Long id,userRegister myResource) throws Exception;

    // public userRegister login(userRegister myResource) throws Exception;
}
