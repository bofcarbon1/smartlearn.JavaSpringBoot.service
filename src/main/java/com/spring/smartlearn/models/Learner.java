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
public class Learner {    
    @Id
    public ObjectId _id;
    public String learnerNo;
    public String learnerName;
    public String learnerNote;
    
    public Learner() {
    
    }
    
    public Learner(ObjectId _id, String learnerNo, String learnerName, 
            String learnerNote) {
        this._id = _id;
        this.learnerNo = learnerNo;
        this.learnerName = learnerName;
        this.learnerNote = learnerNote;
    }
    
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
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
