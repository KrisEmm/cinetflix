/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services;

import com.krisemm.app.models.Detail;
import java.util.List;

/**
 *
 * @author kristian
 */
public interface DetailService {
    void save(Detail detail);
    List<Detail> all();
    void delete(Integer id);
}
