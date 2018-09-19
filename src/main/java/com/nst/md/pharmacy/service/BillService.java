package com.nst.md.pharmacy.service;


import com.nst.md.pharmacy.domain.Bill;
import com.nst.md.pharmacy.domain.BillItem;
import com.nst.md.pharmacy.domain.Medicine;

import java.util.List;

public interface BillService {

    List<Bill> findAll();

    List<Bill> findByMedicineName(Medicine medicine);

    Bill save(Bill bill);

    //BillItem saveBillItem(BillItem billItem);
}
