/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.smartlearn.helpers;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author bofcarbon1
 */
public class helpers {
    
    public JSONArray getFilteredExamples(JSONArray exampleArray) {
        try{
            for (int i = 0; i < exampleArray.size(); i++) {
                JSONObject rec = (JSONObject) exampleArray.get(i);
                System.out.println(exampleArray.get(i));
                if(rec.get("id").equals("2")) {
                    System.out.println("found a match");                
                }
            }
         }catch(Exception e){
            System.out.println(e);                       
        }
        return exampleArray;                
    }   
    
    public JSONArray getFilteredExamplesJ8(JSONArray exampleArray) {
        JSONArray filteredArray = new JSONArray();
        exampleArray.forEach(
            item -> {
            try {		
                JSONObject itemobj = (JSONObject) item;
                    if(itemobj.get("id").equals("2")) {
                        System.out.println("found a match");  
                        filteredArray.add(item);
                    }                    
                }           
            catch(Exception e){
                System.out.println(e);                       
            } 
        });
        return filteredArray;                
    }  
}
