package com.nst.md.pharmacy.service.impl;

import com.nst.md.pharmacy.dao.BillDAO;
import com.nst.md.pharmacy.domain.Bill;
import com.nst.md.pharmacy.domain.BillItem;
import com.nst.md.pharmacy.domain.Medicine;
import com.nst.md.pharmacy.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDAO billDAO;

    @Override
    public List<Bill> findAll() {
        return billDAO.findAll();
    }

    @Override
    public List<Bill> findByMedicineName(Medicine medicine) {
        return null;
    }

    @Override
    public Bill save(Bill bill) {
        //mora sigurno i da se napise upit za cuvanje stavki
        //pa sad ovo pod transakcijom, verovatno
        for (BillItem billItem : bill.getBillItemList()) {
          //  saveBillItem(billItem);
        }
       return billDAO.save(bill);
    }

   /* @Override
    public BillItem saveBillItem(BillItem billItem) {
        return billDAO.saveBillItem(billItem);
    }
    */
}
