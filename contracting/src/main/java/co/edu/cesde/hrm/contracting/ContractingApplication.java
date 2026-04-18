package co.edu.cesde.hrm.contracting;

import co.edu.cesde.hrm.shared.config.SharedAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SharedAutoConfiguration.class)
public class ContractingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractingApplication.class, args);
    }
}
