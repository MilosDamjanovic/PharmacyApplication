package com.nst.md.pharmacy.service.impl;

import com.nst.md.pharmacy.dao.MedicineDAO;
import com.nst.md.pharmacy.domain.Medicine;
import com.nst.md.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "medicineService")
@Transactional
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    private MedicineDAO medicineDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> findAll() {
        return medicineDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> findAllByName(String name) throws Exception{
        try{
            return medicineDAO.findAllByName(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> findAllByManufacturer(String manufacturer) {
        return medicineDAO.findAllByManufacturer(manufacturer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Medicine saveMedicine(Medicine medicine) throws Exception {
        try{
            return medicineDAO.save(medicine);
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Medicine updateMedicine(Medicine medicine) throws Exception{
        try{
            return medicineDAO.save(medicine);
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception();
        }
    }
}
