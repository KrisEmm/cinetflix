/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.User;
import com.krisemm.app.repositories.UserRepositoryJPA;
import com.krisemm.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
public class InMySQLUserService implements UserService {
    
    @Autowired
    private UserRepositoryJPA repository;
    
    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User byId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
