package com.example.config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;


@Configuration
public class H2Config {
    @Value("${h2db.port}")
    private String port;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", port);
    }
    //spring.datasource.url=jdbc:h2:tcp://localhost:9090/mem:addressdb
    //spring.datasource.url=jdbc:h2:tcp://localhost:9090/file:/Users/sona/IdeaProjects/addressdb
    //spring.datasource.url=jdbc:h2:file:/Users/sona/IdeaProjects/addressdb
}
