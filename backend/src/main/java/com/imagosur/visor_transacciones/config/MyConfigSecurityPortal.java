package com.imagosur.visor_transacciones.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.imagosur.security.SecurityService;
import com.imagosur.security.SecurityServicePortalImpl;
import com.imagosur.security.portal.UserDomainConverter;
import com.imagosur.security.portal.UserDomainConverterImpl;
import com.imagosur.wService.IUserManagerClient;
import com.imagosur.wService.impl.UserManagerClientImpl;

@Configuration
@Profile("portal")
public class MyConfigSecurityPortal {

    @Bean
    public SecurityService getSecurityService(@Autowired IUserManagerClient userManagerClient,
            @Autowired UserDomainConverter userDomainConverter) {
        SecurityServicePortalImpl securityService = new SecurityServicePortalImpl();
        securityService.setUserManager(userManagerClient);
        securityService.setUserDomainConverter(userDomainConverter);
        return securityService;
    }

    @Bean
    public IUserManagerClient getUserManagerClient(
            @Value("${security.service.portal.applicationId:999}") String applicationId,
            @Value("${security.service.portal.url}") String userServiceUrl) {
        UserManagerClientImpl userManagerClient = new UserManagerClientImpl();
        userManagerClient.setApplication(applicationId);
        userManagerClient.setUserService(userServiceUrl);
        return userManagerClient;
    }

    @Bean
    public UserDomainConverter getUserDomainConverter() {
        UserDomainConverterImpl userDomainConverter = new UserDomainConverterImpl();
        return userDomainConverter;
    }

}
