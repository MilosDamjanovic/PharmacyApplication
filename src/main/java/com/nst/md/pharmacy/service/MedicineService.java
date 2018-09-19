package com.nst.md.pharmacy.service;


import com.nst.md.pharmacy.domain.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> findAll() throws Exception;

    List<Medicine> findAllByName(String name) throws Exception;

    List<Medicine> findAllByManufacturer(String manufacturer) throws Exception;

    Medicine saveMedicine(Medicine medicine) throws Exception;

    Medicine updateMedicine(Medicine medicine) throws Exception;

}
