package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuddyInfoController {

    @Autowired
    //private AddressBookRepo addressBookRepo;
    private BuddyInfoRepo buddyInfoRepo;

    @PostMapping("/addBuddy")
    public BuddyInfo createEntity(@RequestBody BuddyInfo buddyInfo){
        return buddyInfoRepo.save(buddyInfo);
    }
    @DeleteMapping("/removeBuddy")
    public void removeEntity(@PathVariable Long id){
        buddyInfoRepo.deleteById(id);
    }
}
