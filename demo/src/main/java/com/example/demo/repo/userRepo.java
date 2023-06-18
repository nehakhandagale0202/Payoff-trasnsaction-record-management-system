package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.userRegister;



public interface userRepo extends CrudRepository<userRegister, Long>{
    
    Optional<userRegister> findByMobileNumber(String mobileNumber);
}
