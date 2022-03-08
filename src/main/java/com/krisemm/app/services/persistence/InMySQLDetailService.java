/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.Detail;
import com.krisemm.app.repositories.DetailRepositoryJPA;
import com.krisemm.app.services.DetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMySQL")
public class InMySQLDetailService implements DetailService {
    
    @Autowired
    private DetailRepositoryJPA repository;
    
    @Override
    public void save(Detail detail) {
        repository.save(detail);
    }

    @Override
    public List<Detail> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}
