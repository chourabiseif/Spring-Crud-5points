package com.fivepoints.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CORS & CSRF for this example
        httpSecurity.cors().and().csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll();
                // all other requests need to be authenticated
                //.anyRequest().authenticated().and()
                // make sure we use stateless session; session won't be used to
                // store user's state.
                //.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
       // httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
