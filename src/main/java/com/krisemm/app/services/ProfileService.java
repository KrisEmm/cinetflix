/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services;

import com.krisemm.app.models.Profile;
import java.util.List;

/**
 *
 * @author kristian
 */
public interface ProfileService {
    void save(Profile profile);
    List<Profile> all();
    Profile byId(Integer id);
    void delete(Integer id);
}
