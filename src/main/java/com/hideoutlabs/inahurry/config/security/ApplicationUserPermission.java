package com.hideoutlabs.inahurry.config.security;

public enum ApplicationUserPermission {

    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    ROUTE_READ("route:read"),
    ROUTE_WRITE("route:write");



    private final String permission;

  ApplicationUserPermission(String permission) {

        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
