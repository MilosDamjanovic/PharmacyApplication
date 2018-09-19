package com.nst.md.pharmacy.service.impl;

import com.nst.md.pharmacy.dao.PerscriptionDAO;
import com.nst.md.pharmacy.domain.Perscription;
import com.nst.md.pharmacy.service.PerscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "perscriptionServce")
@Transactional
public class PerscriptionServiceImpl implements PerscriptionService {

    @Autowired
    private PerscriptionDAO perscriptionDAO;

    @Transactional(readOnly = true)
    public List<Perscription> findAll() throws Exception {
        return perscriptionDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Perscription> findByName(String name) throws Exception {
        return null;
    }
}
