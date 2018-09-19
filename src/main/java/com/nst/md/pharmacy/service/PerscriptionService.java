package com.nst.md.pharmacy.service;

import com.nst.md.pharmacy.domain.Perscription;

import java.util.List;

public interface PerscriptionService {

    List<Perscription> findAll() throws Exception;

    List<Perscription> findByName(String name) throws Exception;
}
