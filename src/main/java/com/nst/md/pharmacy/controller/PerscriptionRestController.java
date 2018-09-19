package com.nst.md.pharmacy.controller;


import com.nst.md.pharmacy.domain.Perscription;
import com.nst.md.pharmacy.service.PerscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perscription")
public class PerscriptionRestController {

    @Autowired
    private PerscriptionService perscriptionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAll(){
        List<Perscription> perscriptionList;
        try{
            perscriptionList = perscriptionService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(perscriptionList);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perscription not found.");
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAllByName(@PathVariable String name){
        List<Perscription> perscriptions = null;
        try {
            perscriptions = perscriptionService.findByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(perscriptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
