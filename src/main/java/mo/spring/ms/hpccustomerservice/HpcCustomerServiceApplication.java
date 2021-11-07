package mo.spring.ms.hpccustomerservice;

import mo.spring.ms.hpccustomerservice.entities.Customer;
import mo.spring.ms.hpccustomerservice.repositories.CustomerRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class HpcCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpcCustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Customer.class);

        return args -> {
            customerRepository.save(new Customer(null, "Moussa", "moussa@gmail.com"));
            customerRepository.save(new Customer(null, "Customer1", "customer1@gmail.com"));
            customerRepository.save(new Customer(null, "Customer2", "customer2@gmail.com"));

            customerRepository.findAll().forEach(c ->
                System.out.println(c.toString())
            );
        };
    }
}
