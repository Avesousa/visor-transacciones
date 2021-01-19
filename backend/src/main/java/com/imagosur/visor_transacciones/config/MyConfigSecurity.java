package com.imagosur.visor_transacciones.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.imagosur.security.MyAuthenticationEntryPoint;
import com.imagosur.security.MyAuthenticationProvider;
import com.imagosur.security.SecurityKeyFilter;
import com.imagosur.security.SecurityService;

@Configuration
@EnableWebSecurity
public class MyConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApplicationContext context = getApplicationContext();
        http.authorizeRequests().antMatchers("/**").authenticated();
        //http.authorizeRequests().antMatchers("/form/**").authenticated();
        //http.authorizeRequests().antMatchers("/**").denyAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
        http.httpBasic().authenticationEntryPoint(
                context.getBean("security.auth.entry.point", MyAuthenticationEntryPoint.class));
        http.csrf().disable();
        http.cors();
        http.addFilterBefore(context.getBean("security.key.filter", SecurityKeyFilter.class),
                BasicAuthenticationFilter.class);
        http.headers().frameOptions().disable();
        http.authenticationProvider(context.getBean("security.auth.provider", MyAuthenticationProvider.class));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/webjars/**");
        web.ignoring().antMatchers("/tareas/**");
    }


    @Bean("security.key.filter")
    public SecurityKeyFilter getSecurityKeyFilter(@Autowired SecurityService securityService) {
        SecurityKeyFilter filter = new SecurityKeyFilter();
        filter.setSecurityService(securityService);
        return filter;
    }

    @Bean("security.auth.entry.point")
    public MyAuthenticationEntryPoint getMyAuthenticationEntryPoint() {
        MyAuthenticationEntryPoint authEntryPoint = new MyAuthenticationEntryPoint();
        return authEntryPoint;
    }

    @Bean("security.auth.provider")
    public MyAuthenticationProvider getMyAuthenticationProvider(@Autowired SecurityService securityService) {
        MyAuthenticationProvider authProvider = new MyAuthenticationProvider();
        authProvider.setSecurityService(securityService);
        return authProvider;
    }
}
