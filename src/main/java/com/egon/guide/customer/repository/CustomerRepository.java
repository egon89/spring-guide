package com.egon.guide.customer.repository;

import com.egon.guide.customer.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {
    List<CustomerEntity> findByLastName(String lastName);
}
