package home.narvekar.spring.boot.application.registration;


import home.narvekar.spring.boot.application.registration.producer.RegistrationKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class RestRegistrationController {

    @Autowired
    private RegistrationKafkaProducer producer;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    String register(@RequestParam("message") String message) {
        System.out.println("message is received as : " + message);
        producer.produce(message);
        return "Registration is done successfully !"+message;
    }
    public static void main(String[] args) {
        SpringApplication.run(RestRegistrationController.class, args);
    }
}
