package com.hideoutlabs.inahurry.auth;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import static com.hideoutlabs.inahurry.config.security.ApplicationUserRoles.CUSTOMER;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordstr = bCryptPasswordEncoder.encode("password");

        List<ApplicationUser> applicationUsers = Lists.newArrayList(


                new ApplicationUser(CUSTOMER.getGrantedAuthorities(),
                        passwordstr, "User",
                        true,
                        true,
                        true),
                new ApplicationUser(CUSTOMER.getGrantedAuthorities(),
                        passwordstr, "Admin",
                        true,
                        true,
                        true),

                new ApplicationUser(CUSTOMER.getGrantedAuthorities(),
                        passwordstr, "Report",
                        true,
                        true,
                        true)


                );

        return applicationUsers;
    }
}

