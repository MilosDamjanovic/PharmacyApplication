package com.nst.md.pharmacy.controller;

import com.nst.md.pharmacy.domain.Medicine;
import com.nst.md.pharmacy.facade.CoreFacade;
import com.nst.md.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineRestController {

    @Autowired
    private CoreFacade coreFacade;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getAll() {
        List<Medicine> medicineList = null;
        try {
            medicineList = coreFacade.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(medicineList);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found.");
        }
    }

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getByName(@PathVariable String name) {

        List<Medicine> medicines = null;

        try {
            medicines = coreFacade.findAllByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(medicines);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicines with :" + name + " are not found.");
        }
    }

    @RequestMapping(value = "/get/{manufacturer}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getByManufacturer(@PathVariable String manufacturer) {
        List<Medicine> medicineList = null;
        try {
            medicineList = coreFacade.findAllByManufacturer(manufacturer);
            return ResponseEntity.status(HttpStatus.OK).body(medicineList);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine produced by: " + manufacturer + " could not be found.");
        }
    }

    @RequestMapping(value = "/update/{medicineId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object update(@PathVariable Long medicineId, @RequestBody Medicine m) {
        Medicine med = null;
        try {
            med = coreFacade.update(m, medicineId);
            return ResponseEntity.status(HttpStatus.OK).body(med);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could't update medicine: " + m.toString());
        }
    }


    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object save(@RequestBody Medicine m) {
       Medicine medicine = null;
        try {
            medicine = coreFacade.save(m);
            return ResponseEntity.status(HttpStatus.OK).body(medicine);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine is not saved!");
        }
    }
}
