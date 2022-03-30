package br.com.mobintech.barbearia.config;

import br.com.mobintech.barbearia.service.EmailService;
import br.com.mobintech.barbearia.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

}