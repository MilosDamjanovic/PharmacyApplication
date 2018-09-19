package com.nst.md.pharmacy.service.impl;

import com.nst.md.pharmacy.dao.EmployeeDAO;
import com.nst.md.pharmacy.domain.Employee;
import com.nst.md.pharmacy.service.EmployeeService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional(readOnly = true)
    public Employee login(String username, String password) throws Exception {
    return employeeDAO.login(username,password);
    }

    @Override
    @Transactional(readOnly = true)
    public String authenticate(Employee employee) throws Exception {
        Employee employeeDB = employeeDAO.login(employee.getUsername(), employee.getPassword());
        if(employeeDB ==null) {
            throw new Exception("Unknown employee");
        }
        String token = employeeDB.getUsername() + ":" + employeeDB.getFirstName();
        //token prethodno mora biti enkodiran
        return new String(Base64.encodeBase64(token.getBytes()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findUserByVocation(String vocation) throws Exception {
        List<Employee> usersByVocation= employeeDAO.findUserByVocation(vocation);

        return usersByVocation;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findByUsername(String username) throws Exception {

        Employee u = employeeDAO.findUserByUsername(username);
        if(u==null){
            throw new Exception("Could't find user with username: "+username);
        }

        return u;
    }
}
