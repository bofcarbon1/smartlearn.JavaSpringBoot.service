/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.smartlearn.models;

//import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bofcarbon1
 * model for mongoDB document collection Learner data
 */

//@Document(collection = "learner")
public class LearnerNew {    
    public String learnerName;
    public String learnerNo;
    public String learnerNote;
    
    public LearnerNew() {
    
    }
    
    public LearnerNew(String learnerNo, String learnerName, String learnerNote) {
        this.learnerNo = learnerNo;
        this.learnerName = learnerName;
        this.learnerNote = learnerNote;
    }   

    public String getLearnerNo() {
        return learnerNo;
    }

    public void setLearnerNo(String learnerNo) {
        this.learnerNo = learnerNo;
    }
           
    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }
    
    public String getLearnerNote() {
        return learnerNote;
    }

    public void setLearnerNote(String learnerNote) {
        this.learnerNote = learnerNote;
    }   
    
}


