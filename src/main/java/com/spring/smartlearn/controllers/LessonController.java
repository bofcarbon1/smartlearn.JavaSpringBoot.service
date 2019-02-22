package com.spring.smartlearn.controllers;

import com.spring.smartlearn.models.Lesson;
import com.spring.smartlearn.models.LessonNew;
import com.spring.smartlearn.repositories.LessonIRepository;
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
@RequestMapping("api/lesson")
public class LessonController {
    @Autowired            
    LessonIRepository lessonRepository;
  
    @RequestMapping(value = "/lessons", method = RequestMethod.GET)
    public List<Lesson> getAllLessons() {
        List<Lesson> lessonList = null; 
        try{
            lessonList = lessonRepository.findAll();        
        }catch(Exception e){
            System.out.println(e);             
        }   
        return lessonList;
    }
    
    @RequestMapping(value = "/ById/{id}", method = RequestMethod.GET)
    public Lesson getLessonById(@PathVariable("id") ObjectId id) {
        return lessonRepository.findBy_id(id);
    }
    
    @RequestMapping(value = "/ByCourse/{courseNo}", method = RequestMethod.GET)
    public List<Lesson> getLessonsByCourseNo(@PathVariable("courseNo") String courseNo) {
        List<Lesson> lessons = lessonRepository.findBycourseNoLike(courseNo);
        System.out.println("getLessonsByCoursNo: courseNo: " + courseNo);
        System.out.println("getLessonsByCoursNo: lessons size: " + lessons.size());
        return lessons; 
    }
    
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public String modifyLessonById(@Valid @RequestBody Lesson lesson) {
        ObjectId id = lesson._id;
        lesson.setId(id);
        lessonRepository.save(lesson);
        return "200";
    }
  
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String createLesson(@RequestBody LessonNew lessonNew) {
        Lesson lesson = new Lesson();
        lesson.setId(ObjectId.get());
        lesson.lessonNo = lessonNew.lessonNo;
        lesson.courseNo = lessonNew.courseNo;
        lesson.lessonName = lessonNew.lessonName;
        lesson.lessonDesc = lessonNew.lessonDesc;
        lesson.projectNo = lessonNew.projectNo;
        lesson.taskNo = lessonNew.taskNo;
        lessonRepository.save(lesson);
        return "200";
    }
  
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteLesson(@PathVariable ObjectId id) {
        lessonRepository.delete(lessonRepository.findBy_id(id));
        return "200";
    }
    
}
