package com.hideoutlabs.inahurry.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.hideoutlabs.inahurry.config.ApplicationUserPermission.*;

public enum ApplicationUserRoles {

    CUSTOMER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ROUTE_READ,ROUTE_WRITE,CUSTOMER_READ,CUSTOMER_WRITE)),
    REPORTER(Sets.newHashSet(ROUTE_READ,CUSTOMER_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
     Set<SimpleGrantedAuthority>  permissions= getPermissions().stream()
                .map(permission->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permissions;

    }
}
