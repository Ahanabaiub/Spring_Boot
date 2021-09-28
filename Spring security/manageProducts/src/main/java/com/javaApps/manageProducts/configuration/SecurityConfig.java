package com.javaApps.manageProducts.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("Tanvir").password("{noop}12345").authorities("ROLE_USER")
//                .and()
//                .withUser("Rifat").password("{noop}112233").authorities("ROLE_USER");

//        auth.jdbcAuthentication()
//                .dataSource(dataSource);

//        auth
//                .ldapAuthentication()
//                .userSearchFilter("(uid={0})")
//                .groupSearchFilter("member={0}");


        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/create","/allProducts")
                .hasRole("USER")
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login");
    }
}



