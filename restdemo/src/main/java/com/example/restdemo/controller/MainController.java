package com.example.restdemo.controller;

import com.example.restdemo.model.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*
    Author: Dibya
    Desc: RestApi(Produce)
*/

@RestController
public class MainController {

    public UserData getUserData(){
        UserData userData = new UserData();
        userData.setId(100);
        userData.setUserName("dibya");
        return userData;
    }

    @GetMapping("/getuser/{userid}")
    public ResponseEntity<UserData> getUser(@PathVariable("userid") Integer userid){

        if(getUserData().getId()!=userid)
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);

        else if(getUserData().getId()==userid)
            return new ResponseEntity<>(getUserData(),HttpStatus.OK);

        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

    
    @PostMapping(value="/adduser")
    public ResponseEntity<String> addUser(@RequestBody UserData userData) {

        System.out.println(userData);
        return new ResponseEntity<String>("User added",HttpStatus.CREATED);
        
    }
    
    
}
