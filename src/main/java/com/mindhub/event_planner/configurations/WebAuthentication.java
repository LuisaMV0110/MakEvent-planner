package com.mindhub.event_planner.configurations;

import com.mindhub.event_planner.models.Admin;
import com.mindhub.event_planner.models.Customer;
import com.mindhub.event_planner.models.Manager;
import com.mindhub.event_planner.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( username -> {
            Customer customer = customerRepository.findByEmail(username).orElseThrow( () -> new UsernameNotFoundException("Customer not found with username: " + username));
            return new User(customer.getEmail(), customer.getPassword(), AuthorityUtils.createAuthorityList(customer instanceof Admin ? "ADMIN" : customer instanceof Manager ? "MANAGER" : "USER"));
        });
    }

}
