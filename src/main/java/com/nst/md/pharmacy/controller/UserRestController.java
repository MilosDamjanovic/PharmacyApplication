package com.nst.md.pharmacy.controller;


import com.nst.md.pharmacy.domain.Employee;
import com.nst.md.pharmacy.facade.CoreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class UserRestController {

    @Autowired
    private CoreFacade coreFacade;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody
    Object login(@RequestBody Employee employee){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(coreFacade.authenticate(employee));
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee: "+ employee.getUsername()+" was not fouund.\n");
        }
    }

    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
    public @ResponseBody
    Object get(@PathVariable String username) {
        Employee e = null;
        try{
            e = coreFacade.findByUsername(username);
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }

}
