package server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@EntityScan(basePackages = { "commons", "server" })
@PropertySource("classpath:application-private.properties")
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     *
     */
    @Override
    public void run(String[] args) throws IOException {

    }
}
