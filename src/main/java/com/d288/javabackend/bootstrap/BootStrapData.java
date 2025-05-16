package com.d288.javabackend.bootstrap;

import com.d288.javabackend.dao.CustomerRepository;
import com.d288.javabackend.dao.DivisionRepository;
import com.d288.javabackend.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Long customerCount = customerRepository.count();

        if (customerCount <= 1) {
            Customer jim = new Customer();
            jim.setFirstName("Jim");
            jim.setLastName("Halpert");
            jim.setAddress("13831 Calvert St");
            jim.setPostal_code("91401");
            jim.setPhone("919-123-4567");
            jim.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(jim);

            Customer pam = new Customer();
            pam.setFirstName("Pam");
            pam.setLastName("Halpert");
            pam.setAddress("13831 Calvert St");
            pam.setPostal_code("91401");
            pam.setPhone("919-987-3875");
            pam.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(pam);

            Customer dwight = new Customer();
            dwight.setFirstName("Dwight");
            dwight.setLastName("Schrute");
            dwight.setAddress("Schrute Farms, Rural Rt");
            dwight.setPostal_code("18431");
            dwight.setPhone("919-119-3278");
            dwight.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(dwight);

            Customer michael = new Customer();
            michael.setFirstName("Michael");
            michael.setLastName("Scott");
            michael.setAddress("1725 Slough Avenue");
            michael.setPostal_code("18431");
            michael.setPhone("919-122-3298");
            michael.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(michael);

            Customer angela = new Customer();
            angela.setFirstName("Angela");
            angela.setLastName("Kinsey");
            angela.setAddress("9218 Scranton Avenue");
            angela.setPostal_code("18421");
            angela.setPhone("919-746-3998");
            angela.setDivision(divisionRepository.getReferenceById(31L));
            customerRepository.save(angela);
        }
    }

}
