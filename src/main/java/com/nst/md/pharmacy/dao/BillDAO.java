package com.nst.md.pharmacy.dao;

import com.nst.md.pharmacy.domain.Bill;
import com.nst.md.pharmacy.domain.BillItem;
import com.nst.md.pharmacy.domain.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface BillDAO extends CrudRepository<Bill, Long> {

    //mora mandatory!!!
    @Query("select b from Bill b")
    List<Bill> findAll();

    @Query("select b from Bill b where b.issueDate=?1")
    List<Bill> findBillByIssueDate(Date issueDate);
}