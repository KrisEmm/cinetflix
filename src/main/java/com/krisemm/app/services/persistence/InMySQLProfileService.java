/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.Profile;
import com.krisemm.app.repositories.ProfileRepositoryJPA;
import com.krisemm.app.services.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
public class InMySQLProfileService implements ProfileService {
    
    @Autowired
    private ProfileRepositoryJPA repository;
    
    @Override
    public void save(Profile profile) {
        repository.save(profile);
    }

    @Override
    public List<Profile> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profile byId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
