package com.davymbaimbai.ecommerce.repository;

import com.davymbaimbai.ecommerce.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
