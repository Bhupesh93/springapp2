package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan("backend")
public class Application {
    public static void main(String arg[]){
        ApplicationContext ctx = SpringApplication.run(Application.class, arg);
    }

    @Bean
    @Profile("prod")
    public String dummy(){
        return "retruning some prod details";
    }
}
