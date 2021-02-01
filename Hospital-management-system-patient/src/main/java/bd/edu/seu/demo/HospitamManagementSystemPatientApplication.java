package bd.edu.seu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HospitamManagementSystemPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitamManagementSystemPatientApplication.class, args);
    }

}
