package com.nst.md.pharmacy.security;

import com.nst.md.pharmacy.domain.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class TokenUsers implements Authentication{

    private final Employee employee;
    private boolean isAuth;
    private String token;
    private List<GrantedAuthority> grantedAuthorities;

    public TokenUsers(Employee employee, String token, List<GrantedAuthority> grantedAuthorities){
        super();
        this.employee = employee;
        this.token=token;
        this.grantedAuthorities=grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return employee;
    }

    @Override
    public Object getPrincipal() {
        return employee.getUsername();
    }

    @Override
    public String getName() {
        return employee.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return isAuth;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
    this.isAuth=b;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
}
