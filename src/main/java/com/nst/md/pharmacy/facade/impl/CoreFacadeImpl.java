package com.nst.md.pharmacy.facade.impl;

import com.nst.md.pharmacy.domain.Employee;
import com.nst.md.pharmacy.domain.Medicine;
import com.nst.md.pharmacy.facade.CoreFacade;
import com.nst.md.pharmacy.service.MedicineService;
import com.nst.md.pharmacy.service.EmployeeService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CoreFacadeImpl implements CoreFacade {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public List<Medicine> findAll() throws Exception {
        return medicineService.findAll();
    }

    @Override
    public List<Medicine> findAllByName(String name) throws Exception {
        return medicineService.findAllByName(name);
    }

    @Override
    public List<Medicine> findAllByManufacturer(String manufacturer) throws Exception {
        try{
            medicineService.findAllByManufacturer(manufacturer);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new Exception("Error due to querying medicine by manufacturers name");
        }
        return null;
    }

    @Override
    public void deleteBy() {

    }

    @Override
    public Medicine save(Medicine medicine) throws Exception {
        return medicineService.saveMedicine(medicine);
    }

    @Override
    public Medicine update(Medicine medicine, Long medicineId) throws Exception {
        return medicineService.updateMedicine(medicine);
    }

    @Override
    public Employee login(String username, String password) throws Exception {
        Employee employeeDB = employeeService.login(username,password);
        if(employeeDB ==null){
            System.out.println("Unknown user");
            throw new Exception("Unknown user");
        }
        return employeeDB;
    }

    @Override
    public Employee findByUsername(String username) throws Exception {
        return employeeService.findByUsername(username);
    }

    @Override
    public String authenticate(Employee employee) throws Exception {
        Employee employeeDB = employeeService.login(employee.getUsername(), employee.getPassword());
        if(employeeDB ==null){
            throw new Exception("Unknown employee: "+ employee.toString());
        }
        String token = employeeDB.getUsername() + ":" + employeeDB.getFirstName();
        //token prethodno mora biti enkodiran
        return new String(Base64.encodeBase64(token.getBytes()));
    }

    @Override
    public List<Employee> findByVocation(String vocation) throws Exception {
        List<Employee> usersByVocation= employeeService.findUserByVocation(vocation);

        return usersByVocation;
    }
}
