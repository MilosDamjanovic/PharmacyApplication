package com.nst.md.pharmacy.dao;


import com.nst.md.pharmacy.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    //DAO MORA DA SE ANOTIRA SA REPOSITORY

    @Query("select e from Employee e where username=?1 and password=?2")
    Employee login(String username, String password);

    @Query("SELECT e FROM Employee e WHERE username = ?1")
    Employee findUserByUsername(String username);

    @Query("select e from Employee e where e.vocation=?1")
    List<Employee> findUserByVocation(String vocation);
}
