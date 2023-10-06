package com.egon.guide;

import com.egon.guide.customer.service.CustomerInitService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomRunner implements CommandLineRunner {

    private final CustomerInitService customerInitService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("> Command line runner started...");
        customerInitService.execute();
        System.out.println("> Command line runner finished");
    }
}
