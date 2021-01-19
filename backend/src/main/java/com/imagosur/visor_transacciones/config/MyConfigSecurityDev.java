package com.imagosur.visor_transacciones.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.imagosur.security.SecurityService;
import com.imagosur.security.SecurityServiceDevImpl;
import com.imagosur.security.dev.UserProviderStrategy;
import com.imagosur.security.dev.UserProviderStrategyFromPropertiesImpl;

@Configuration
@Profile("dev")
public class MyConfigSecurityDev {

    @Bean
    public SecurityService getSecurityService(@Autowired UserProviderStrategy userProviderStrategy) {
        SecurityServiceDevImpl securityService = new SecurityServiceDevImpl();
        securityService.setUserProviderStrategy(userProviderStrategy);
        return securityService;
    }

    @Bean
    public UserProviderStrategy getUserProviderStrategy() {
        UserProviderStrategyFromPropertiesImpl userProviderStrategy = new UserProviderStrategyFromPropertiesImpl();
        return userProviderStrategy;
    }
}
