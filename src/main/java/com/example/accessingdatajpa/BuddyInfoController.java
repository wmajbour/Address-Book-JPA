package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuddyInfoController {

    @Autowired
    private AddressBookRepo addressBookRepo;

    @PostMapping("/addBuddy")
    public BuddyInfo createEntity(@RequestBody BuddyInfo buddyInfo){
        return addressBookRepo.save(buddyInfo);
    }
}
