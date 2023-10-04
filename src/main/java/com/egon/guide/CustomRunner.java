package com.egon.guide;

import com.egon.guide.customer.entity.CustomerEntity;
import com.egon.guide.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class CustomRunner implements CommandLineRunner {

    private final CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("> Command line runner started...");
        repository.save(CustomerEntity.builder().firstName("John").lastName("Doe").build());
        Stream.of(repository.findAll()).forEach(System.out::println);
        System.out.println("> Command line runner finished");
    }
}
