package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
@RepositoryRestResource
public interface AddressBookRepo extends CrudRepository<AddressBook, Long> {

    AddressBook findById(long id);

}
