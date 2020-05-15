package com.library.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.POST, "/retrievement/*").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/retrievement/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/retrievement/*").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/retrievement/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/book/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/author/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/category/*").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/subcategory/*").hasRole("USER")
                .antMatchers("/*","/**","/***","/****").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/index").and().logout().logoutSuccessUrl("/login");

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails theUser = User.withUsername("user")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("12345678").roles("USER").build();

        UserDetails theManager = User.withUsername("admin")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("12345678").roles("ADMIN").build();


        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theManager);

        return userDetailsManager;
    }


}