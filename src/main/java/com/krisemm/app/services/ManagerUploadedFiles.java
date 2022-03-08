/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services;

import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kristian
 */
@Service
public class ManagerUploadedFiles{
    
    @Autowired 
    private ServletContext context;
    
    public String store(MultipartFile file) {
        String id = generateShortId(5);
        String name = file.getOriginalFilename();
        name = name.replace(" ", "-");
        name = id.concat("-").concat(name);
        String rootPath = context.getRealPath("/WEB-INF/resources/images/");
        String path = rootPath +"/"+ name;
        try{
            file.transferTo(Paths.get(path));
            return name;
        }catch(IOException e){
            System.out.println(e);
        }
        return null;
    }
    
    private String generateShortId(int length){
        String Characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder id = new StringBuilder();
        while(length-- > 0){
            int getRandomCharacter = (int) (Math.random() * Characters.length());
            id.append(Characters.charAt(getRandomCharacter));
        }
        return id.toString();
    }
}
