package com.spring.smartlearn.repositories;

import com.spring.smartlearn.models.Learner;
//import com.spring.smartlearn.helpers.helpers;
//import java.io.FileReader;
import java.util.List;
import org.bson.types.ObjectId;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author bofcarbon1
 */
public interface LearnerIRepository extends MongoRepository<Learner, String>{
       
    List<Learner> findAll();
    Learner findBy_id(ObjectId _id);
    List<Learner> findBylearnerNameLike(String filter);
    //void save(Learner); 
    //String save(Learner);    
   
}
