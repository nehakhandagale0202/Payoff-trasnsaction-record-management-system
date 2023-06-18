package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.userRegister;
import com.example.demo.repo.userRepo;
import com.example.demo.service.userRegService;

@RestController
@RequestMapping("user")
public class userRegController {
    @Autowired
    private userRegService userService;

    @Autowired
    private userRepo userRepo;

    @PostMapping("AddUser")
    public ResponseEntity<userRegister> AddUser(@RequestBody userRegister user2){
        userRegister emp = null;
        try{
            emp=userService.AddORUpdate(user2);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<userRegister>(emp, HttpStatus.OK);
    }

    @GetMapping("allUser")
    public ResponseEntity<List<userRegister>> getAll(){
        List<userRegister> emp = null;
        try{
            emp=userService.getAll();
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<userRegister>>(emp, HttpStatus.OK);
    }

    @GetMapping("getbyId/{id}")
    public ResponseEntity<userRegister> getbyID(@PathVariable("id") Long id){
        userRegister emp = null;
        try{
            emp=userService.getbyID(id);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<userRegister>(emp, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<userRegister> delete(@PathVariable("id") Long id) {
        userRegister emp = null;
        try{
            emp=userService.delete(id);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<userRegister>(emp, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<userRegister> update(@PathVariable("id") Long id,@RequestBody userRegister myResource) {
        userRegister emp = null;
        try{
            emp=userService.update(id,myResource);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<userRegister>(emp, HttpStatus.OK);
    }

    // @PostMapping("login")
    // public ResponseEntity<userRegister> login(@RequestBody userRegister myResource){
    //     userRegister emp = null;
    //     try{
    //         System.out.println("this is emp - "+emp);
    //         emp=userService.login(myResource);
    //         System.out.println("this is emp - "+emp);
    //     }catch(Exception ex){
    //         ex.getMessage();
    //     }
    //     System.out.println(emp);
    //     if(emp == null){
    //         System.out.println(emp);
    //         return new ResponseEntity<userRegister>(emp, HttpStatus.OK);
    //     }
    //     else{
    //         return new ResponseEntity<userRegister>(emp, HttpStatus.BAD_REQUEST);
    //     }
       
    // }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> json) {
        String username = json.get("username");
        String password = json.get("password");

        Optional<userRegister> optionalUser = userRepo.findByMobileNumber(username);

        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            return ResponseEntity.ok("Login successful.");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
    }

    
}
