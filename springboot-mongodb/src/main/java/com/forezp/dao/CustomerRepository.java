package com.forezp.dao;

import java.util.List;

import com.forezp.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

     Customer findByFirstName(String firstName);
     List<Customer> findByLastName(String lastName);

}