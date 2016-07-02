package be.plutus.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan( { "be.plutus.core" } )
@ComponentScan( basePackages = { "be.plutus" } )
@EnableJpaRepositories( basePackages = {"be.plutus.core.repository", "be.plutus.core.service"} )
@SpringBootApplication( scanBasePackages = "be.plutus.api" )
public class Application{

    public static void main( String[] args ){
        SpringApplication.run( Application.class, args );
    }

}
