package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepo extends CrudRepository<BuddyInfo, Long> {

    AddressBook findById(long id);

}
