/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.smartlearn.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bofcarbon1
 */
public class CourseNew {
    public String courseNo;
    public String courseName;
    public String courseDesc;
    
    public CourseNew() {
    
    }
    
    public CourseNew(String courseNo, String courseName, String courseDesc) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
    } 

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }
    
}
