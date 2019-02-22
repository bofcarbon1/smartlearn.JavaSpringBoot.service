/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.smartlearn.controllers;

import com.spring.smartlearn.models.Learner;
import com.spring.smartlearn.models.LearnerNew;
import com.spring.smartlearn.repositories.LearnerIRepository;
import java.util.List;
import javax.validation.Valid;
//import java.util.Optional;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
//import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bofcarbon1
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/learner")
public class LearnerController {
    
    @Autowired            
    LearnerIRepository learnerRepository;
  
    @RequestMapping(value = "/learners", method = RequestMethod.GET)
    public List<Learner> getAllLearners() {
        List<Learner> learnerList = null; 
        try{
            learnerList = learnerRepository.findAll();        
        }catch(Exception e){
            System.out.println(e);             
        }   
        return learnerList;
    }
    
    @RequestMapping(value = "/ById/{id}", method = RequestMethod.GET)
    public Learner getLearnerById(@PathVariable("id") ObjectId id) {
        System.out.println("getLearnerById: id: " + id);
        return learnerRepository.findBy_id(id);
    }
    
    @RequestMapping(value = "/ByFilter/{filter}", method = RequestMethod.GET)
    public List<Learner> getLearnerByFilter(@PathVariable("filter") String filter) {
        System.out.println("getLearnerByFilter: filter: " + filter);
        return learnerRepository.findBylearnerNameLike(filter);
    }
    
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public String modifyLearnerById(@Valid @RequestBody Learner learner) {
        ObjectId id = learner._id;
        learner.setId(id);
        learnerRepository.save(learner);
        return "200";
    }
  
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String createLearner(@RequestBody LearnerNew learnerNew) {
        Learner learner = new Learner();
        learner.setId(ObjectId.get()); 
        learner.learnerNo = learnerNew.learnerNo;
        learner.learnerName = learnerNew.learnerName;
        learner.learnerNote = learnerNew.learnerNote;
        learnerRepository.save(learner);
        return "200";
    }
  
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteLearner(@PathVariable ObjectId id) {
        learnerRepository.delete(learnerRepository.findBy_id(id));
        return "200";
    }
    
}
