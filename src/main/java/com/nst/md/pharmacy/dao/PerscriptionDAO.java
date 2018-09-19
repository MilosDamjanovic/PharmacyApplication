package com.nst.md.pharmacy.dao;

import com.nst.md.pharmacy.domain.Perscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface PerscriptionDAO extends CrudRepository<Perscription, Long> {

    @Query("select p from Perscription  p")
    List<Perscription> findAll();

}
