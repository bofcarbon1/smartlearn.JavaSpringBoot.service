package com.spring.smartlearn.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
/**
 *
 * @author bofcarbon1
 */
public class Lesson {
    @Id
    public ObjectId _id;
    public String lessonNo;
    public String courseNo;
    public String lessonName;
    public String lessonDesc;
    public String projectNo;
    public String taskNo;
    
    public Lesson() {
    
    }
      public Lesson(ObjectId _id, String lessonNo, String courseNo, String lessonName, 
              String lessonDesc, String projectNo, String taskNo) {
        this._id = _id;
        this.courseNo = courseNo;
        this.courseNo = courseNo;
        this.lessonName = lessonName;
        this.lessonDesc = lessonDesc;
        this.projectNo = projectNo;
        this.taskNo = taskNo;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
    
    public String getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(String lessonNo) {
        this.lessonNo = lessonNo;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDesc() {
        return lessonDesc;
    }

    public void setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    
    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }
    
    
      
}
