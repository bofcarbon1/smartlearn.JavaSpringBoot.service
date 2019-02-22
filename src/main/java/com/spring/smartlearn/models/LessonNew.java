package com.spring.smartlearn.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bofcarbon1
 */
public class LessonNew {
    public String lessonNo;
    public String courseNo;
    public String lessonName;
    public String lessonDesc;
    public String projectNo;
    public String taskNo;
    
    public LessonNew() {
    
    }
    
    public LessonNew(String lessonNo, String courseNo, String lessonName, 
        String lessonDesc, String projectNo, String taskNo) {
        this.lessonNo = lessonNo;
        this.courseNo = courseNo;
        this.lessonName = lessonName;
        this.lessonDesc = lessonDesc;
        this.projectNo = projectNo;
        this.taskNo = taskNo;
    }  
}
