/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.Timetable;
import com.krisemm.app.services.TimetableService;
import java.util.List;

/**
 *
 * @author kristian
 */
public class InMemoryTimetableService implements TimetableService {

    @Override
    public String save(Timetable timetable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Timetable> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
