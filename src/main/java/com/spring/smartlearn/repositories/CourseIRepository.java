/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.smartlearn.repositories;

import com.spring.smartlearn.models.Course;
import java.util.List;
import com.google.gson.JsonArray;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author bofcarbon1
 */
public interface CourseIRepository extends MongoRepository<Course, String>{
    List<Course> findAll();
    @Query(value="{}", fields="{courseNo : 1}")
    List<String> findcourseNo();
    Course findBy_id(ObjectId _id);
    List<Course> findBycourseNameLike(String filter);
    @Query(value="{}", fields="{courseNo : 1, courseName : 1, _id : 0}")
    List<String> findcourseNoAndcourseName();
}
