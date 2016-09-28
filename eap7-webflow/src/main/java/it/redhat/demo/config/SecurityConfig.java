package it.redhat.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

/**
 * Created by fabio on 28/09/16.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers("/web/employee").access("hasRole('USER')")
                .and()
            .formLogin()
                .loginPage("/web/login")
                .loginProcessingUrl("/web/loginProcess")
                .defaultSuccessUrl("/web/employee")
                .failureUrl("/web/login?login_error=1")
                .and()
            .logout()
                .logoutUrl("/web/logout")
                .logoutSuccessUrl("/web/logoutSuccess")
                .and()

            // Disable CSRF (won't work with JSF) but ensure last HTTP POST request is saved
            // See https://jira.springsource.org/browse/SEC-2498

            .csrf().disable()
            .requestCache()
            .requestCache(new HttpSessionRequestCache());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new Md5PasswordEncoder())
            .withUser("marinelli").password("b3e1d2e3968c66b4199ed5848fe84176").roles("USER", "SUPERVISOR").and()
            .withUser("scardazza").password("f736e3cbb7c82974f0b951978f3141aa").roles("USER", "SUPERVISOR").and()
            .withUser("linguerri").password("4fbfcab4c23a9e4637e8b60901e279a2").roles("USER").and()
            .withUser("foogaro").password("8499ca0f6e4b33fd6308d25760d669ce").roles("USER");
    }
}
