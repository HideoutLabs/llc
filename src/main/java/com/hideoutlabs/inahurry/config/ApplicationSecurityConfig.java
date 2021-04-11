package com.hideoutlabs.inahurry.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.hideoutlabs.inahurry.config.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

   @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http
               .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) //CSRF is sent by the server to a cookie ,Client submits the put|post|delete with that token
               .and()
               .authorizeRequests()
               .antMatchers("/","index","/css/*","/js/*").permitAll()
               .antMatchers("/api/**").hasRole(CUSTOMER.name())
//               .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ROUTE_WRITE.getPermission())
//               .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ROUTE_WRITE.getPermission())
//               .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ROUTE_WRITE.getPermission())
//               .antMatchers("/management/api/**").hasAnyRole(ADMIN.name(), REPORT.name())
               .anyRequest()
               .authenticated()
               .and()
               .formLogin()
               .loginPage("/login").permitAll();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
     UserDetails userDetail=  User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                //.roles(CUSTOMER.name()) //ROLE_CUSTOMER
                .authorities(CUSTOMER.getGrantedAuthorities())
                .build();

     UserDetails adminuserDetail=   User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
               // .roles(ADMIN.name()) //ROLE_ADMIN
             .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails reportuserDetail=   User.builder()
                .username("report")
                .password(passwordEncoder.encode("password123"))
                .roles(REPORT.name()) //ROLE_REPORT
                .authorities(REPORT.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(
                userDetail,adminuserDetail,reportuserDetail
        );
    }
}
