package com.example.demo.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.userRegister;
import com.example.demo.repo.userRepo;

@Service
public class userRegImpl implements userRegService {
    @Autowired
    private userRepo userRepo;

    @Override
    public userRegister AddORUpdate(userRegister emp) {
        
        return userRepo.save(emp);
    }

    @Override
    public List<userRegister> getAll() {

        return (List<userRegister>) userRepo.findAll();
    }

    @Override
    public userRegister getbyID(Long id) {

        return userRepo.findById(id).orElse(null);
    }

    @Override
    public userRegister delete(Long id) throws Exception {

        userRegister deletedEmp = null;
        try {
            deletedEmp = userRepo.findById(id).orElse(null);
            if (deletedEmp == null) {
                throw new Exception("user not available");
            } else {
                userRepo.deleteById(id);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return deletedEmp;
    }

    @Override
    public userRegister update(Long id, userRegister myResource) throws Exception {

        userRegister updateUser = userRepo.findById(id).orElse(null);
        try {
            if (updateUser == null) {
                throw new Exception("user not available");
            } else {
                updateUser.setBuisnessName(myResource.getBuisnessName());
                 updateUser.setEmail(myResource.getEmail());
                updateUser.setFirstName(myResource.getFirstName());
                updateUser.setMobileNumber(myResource.getMobileNumber());

                updateUser = userRepo.save(updateUser);
                return updateUser;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        // return updateEmp;
    }

    // @Override
    // public userRegister login(userRegister myResource) throws Exception {
    //     Optional<userRegister> u = userRepo.findByMobileNumber(myResource.getMobileNumber());
    //     try {
    //         if (u.isEmpty()) {
    //             throw new Exception("user not available");
    //         } else if (u.get().getPassword().equals(myResource.getPassword())) {
    //             System.out.println(("In the login page... matched"));
    //             return myResource;
    //         }
    //     } catch (Exception ex) {
    //         System.out.println(ex.getMessage());
    //         throw ex;
    //     }
    //     return null;
    // }

}
