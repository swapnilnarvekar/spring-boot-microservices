package home.narvekar.spring.boot.application.cancellation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class RestCancellationController {
    //service -> Dao -> student delete

    @RequestMapping(value = "/cancel",method = RequestMethod.GET)
    String home() {
        return "Cancellation is done successfully by Siddhu!";
    }

    public static void main(String[] args) {
        SpringApplication.run(RestCancellationController.class, args);
    }
}
