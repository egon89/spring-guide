package com.egon.guide.customer.service;

import com.egon.guide.customer.dto.CustomerDto;
import com.egon.guide.customer.mapper.CustomerMapper;
import com.egon.guide.customer.repository.CustomerRepository;
import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerInitService {
    private final CustomerMapper mapper;
    private final CustomerRepository repository;

    public void execute() {
        var customer = CustomerDto.builder().firstName("John").lastName("Doe").build();
        repository.save(mapper.toEntity(customer));
        Streams.stream(repository.findAll()).map(mapper::toDto).forEach(System.out::println);
    }
}
