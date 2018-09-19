package com.nst.md.pharmacy.security;

import com.nst.md.pharmacy.domain.Employee;
import com.nst.md.pharmacy.domain.enumtype.EmployeeRoleEnum;
import com.nst.md.pharmacy.facade.CoreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.security.access.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;


@Service
public class TokenService {

    @Autowired
    private CoreFacade coreFacade;

    public String createTokenForEmployee(Employee employee) throws Exception {
        return coreFacade.authenticate(employee);
    }

    public Authentication parseUserFromToken(String token){
        try {
            String decoded = new String(Base64.decodeBase64(token));
            System.out.println(decoded);
            String username = decoded.substring(0, decoded.indexOf(":"));
            Employee employee = coreFacade.findByUsername(username);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (EmployeeRoleEnum r : employee.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(r.name()));
            }
            TokenUsers tokenUsers = new TokenUsers(employee,token, grantedAuthorities);
            tokenUsers.setAuthenticated(true);
            return tokenUsers;
        }catch (Exception e) {
            throw new AccessDeniedException(e.getMessage(), e);
        }
    }

    public Employee getUserFromSpringAuthentication(Authentication authentication) {
        try {
            String currentPrincipalName = authentication.getName();
            return coreFacade.findByUsername(currentPrincipalName);
        } catch (Exception ex) {
            throw new AccessDeniedException(ex.getMessage(), ex);
        }
    }

}
