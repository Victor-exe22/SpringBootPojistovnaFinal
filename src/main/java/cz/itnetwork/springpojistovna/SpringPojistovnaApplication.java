package cz.itnetwork.springpojistovna;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringPojistovnaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPojistovnaApplication.class, args);
    }

}
