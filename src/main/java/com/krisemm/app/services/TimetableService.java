/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services;

import com.krisemm.app.models.Timetable;
import java.util.List;

/**
 *
 * @author kristian
 */
public interface TimetableService {
    String save(Timetable timetable);
    List<Timetable> all();
}
