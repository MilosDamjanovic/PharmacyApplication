package com.nst.md.pharmacy.controller;

import com.nst.md.pharmacy.domain.Bill;
import com.nst.md.pharmacy.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillRestController {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object findAll(){
        List<Bill> billList = billService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(billList);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object save(@RequestBody Bill b){
        Bill bill = billService.save(b);
        return ResponseEntity.status(HttpStatus.OK).body(bill);
    }
}
