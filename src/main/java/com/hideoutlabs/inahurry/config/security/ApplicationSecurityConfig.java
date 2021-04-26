package com.hideoutlabs.inahurry.config.security;


import com.hideoutlabs.inahurry.auth.ApplicationUserService;
import com.hideoutlabs.inahurry.config.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.hideoutlabs.inahurry.config.security.ApplicationUserPermission.CUSTOMER_WRITE;
import static com.hideoutlabs.inahurry.config.security.ApplicationUserPermission.ROUTE_WRITE;
import static com.hideoutlabs.inahurry.config.security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
             //   .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) //CSRF is sent by the server to a cookie ,Client submits the put|post|delete with that token
                //  .and()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(CUSTOMER.name())
                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ROUTE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "api/v1/registration").hasRole(CUSTOMER_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ROUTE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ROUTE_WRITE.getPermission())
                .antMatchers("/management/api/**").hasAnyRole(ADMIN.name(), REPORTER.name())
                .anyRequest()
                .authenticated()
                .and().formLogin();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userDetail = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles(CUSTOMER.name()) //ROLE_CUSTOMER
                .authorities(CUSTOMER.getGrantedAuthorities())
                .build();

        UserDetails adminuserDetail = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name()) //ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails reportuserDetail = User.builder()
                .username("report")
                .password(passwordEncoder.encode("password123"))
                .roles(REPORTER.name()) //ROLE_REPORTER
                .authorities(REPORTER.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(
                userDetail, adminuserDetail, reportuserDetail
        );
    }
}


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//       provider.setPasswordEncoder(passwordEncoder);
//       provider.setUserDetailsService(applicationUserService);
//       return  provider;
//    }
//}
