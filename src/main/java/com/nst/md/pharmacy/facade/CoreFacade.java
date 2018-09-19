package com.nst.md.pharmacy.facade;

import com.nst.md.pharmacy.domain.Employee;
import com.nst.md.pharmacy.domain.Medicine;

import java.util.List;

public interface CoreFacade {
    /*
    MEDICINE
     */
    List<Medicine> findAll() throws Exception;

    List<Medicine> findAllByName(String name) throws Exception;

    List<Medicine> findAllByManufacturer(String manufacturer) throws Exception;

    void deleteBy() throws Exception;

    Medicine save(Medicine medicine) throws Exception;

    Medicine update(Medicine medicine, Long medicineID) throws Exception;

    /*
    PERSCRIPTION
     */

    /*
    USER?
    */
    Employee login(String username, String password) throws Exception;

    Employee findByUsername(String username) throws Exception;

    String authenticate(Employee employee) throws Exception;

    List<Employee> findByVocation(String vocation) throws Exception;

}
