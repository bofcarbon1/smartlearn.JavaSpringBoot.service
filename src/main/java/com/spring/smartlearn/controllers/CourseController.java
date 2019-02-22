
package com.spring.smartlearn.controllers;

import com.spring.smartlearn.models.Course;
import com.spring.smartlearn.models.CourseNew;
import com.spring.smartlearn.repositories.CourseIRepository;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
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
@RequestMapping("api/course")
public class CourseController {
    @Autowired            
    CourseIRepository courseRepository;
  
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courseList = null; 
        try{
            courseList = courseRepository.findAll();        
        }catch(Exception e){
            System.out.println(e);             
        }   
        return courseList;
    }
    
    @RequestMapping(value = "/courseNos", method = RequestMethod.GET)
    public List<String> getAllCourseNos() {
        List<String> courseList = null;        
        try{
            courseList = courseRepository.findcourseNo();             
        }catch(Exception e){
            System.out.println(e);            
        }   
        return courseList;
    }
    
    @RequestMapping(value = "/selects", method = RequestMethod.GET)
    public List<String> getCourseSelects() {
        List<String> courseSelects = null;        
        try{
            courseSelects = courseRepository.findcourseNoAndcourseName();             
        }catch(Exception e){
            System.out.println(e);            
        }   
        return courseSelects;
    }
    
    @RequestMapping(value = "/ById/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable("id") ObjectId id) {
        return courseRepository.findBy_id(id);
    }
    
    @RequestMapping(value = "/ByFilter/{filter}", method = RequestMethod.GET)
    public List<Course> getCourseByFilter(@PathVariable("filter") String filter) {
        return courseRepository.findBycourseNameLike(filter);
    }
    
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public String modifyCourseById(@Valid @RequestBody Course course) {
        ObjectId id = course._id;
        course.setId(id);
        courseRepository.save(course);
        return "200";
    }
  
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String createCourse(@RequestBody CourseNew courseNew) {
        Course course = new Course();
        course.setId(ObjectId.get());
        course.courseNo = courseNew.courseNo;
        course.courseName = courseNew.courseName;
        course.courseDesc = courseNew.courseDesc;
        courseRepository.save(course);
        return "200";
    }
  
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable ObjectId id) {
        courseRepository.delete(courseRepository.findBy_id(id));
        return "200";
    }
    
}
