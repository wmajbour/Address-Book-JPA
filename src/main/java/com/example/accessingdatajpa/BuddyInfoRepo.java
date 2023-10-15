package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepo extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);
    List<BuddyInfo> findByAddress(String address);
    List<BuddyInfo> findByNumber(String number);
    BuddyInfo findById(long id);

}
