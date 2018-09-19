package com.nst.md.pharmacy.dao;

import com.nst.md.pharmacy.domain.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface MedicineDAO extends CrudRepository<Medicine, Long> {

    //promeniti vezu tako da recept bude vezan za ulogu
    //na taj nacin lekar moze samo da izda recept, a njegova uloga je u roles
    @Query("select m from Medicine m")
    List<Medicine> findAll();

    @Query("select m from Medicine m where m.name=:name")
    List<Medicine> findAllByName(String name);

    @Query("select m from Medicine m where m.manufacturer=:manufacturer")
    List<Medicine> findAllByManufacturer(String manufacturer);

}
