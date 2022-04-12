package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public FileOutputStream fileOut() throws FileNotFoundException {
        return new FileOutputStream("1.txt");
    }

    @Bean
    public FileInputStream fileIn() throws FileNotFoundException {
        return new FileInputStream("1.txt");
    }

//    @Bean
//    public List<Product> cart() {
//        return new ArrayList<>();
//    }
}
