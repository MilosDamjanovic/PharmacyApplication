package com.nst.md.pharmacy.service;

import com.nst.md.pharmacy.domain.Employee;

import java.util.List;

public interface EmployeeService {

    //realno je da svi bacaiju izuzetke

    Employee login(String username, String password) throws Exception;

    String authenticate(Employee employee) throws Exception;

    List<Employee> findUserByVocation(String vocation) throws Exception;

    Employee findByUsername(String username) throws Exception;
}
