package io.jwttry.my_app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.jwttry.my_app.domain")
@EnableJpaRepositories("io.jwttry.my_app.repos")
@EnableTransactionManagement
public class DomainConfig {
}
