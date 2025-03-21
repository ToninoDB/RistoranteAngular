package com.example.ristorante_backend.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;

@Configuration
public class ServerConfig {
    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        System.setProperty("server.port", env.getProperty("server.port", "4200"));
    }
}
