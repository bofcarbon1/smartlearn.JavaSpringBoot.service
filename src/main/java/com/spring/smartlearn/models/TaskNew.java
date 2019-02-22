
package com.spring.smartlearn.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author bofcarbon1
 */

public class TaskNew {
    
    public String taskNo;
    public String projectNo;
    public String lessonNo;
    public String learnerNo;
    public String taskName;
    public String taskDesc;
    public String taskPctDone;
    
    public TaskNew() {
    
    }

    public TaskNew(String taskNo, String projectNo, String lessonNo, 
        String learnerNo, String taskName, String taskDesc, String taskPctDone) {
        this.taskNo = taskNo;
        this.projectNo = projectNo;
        this.learnerNo = learnerNo;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
    }   

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(String lessonNo) {
        this.lessonNo = lessonNo;
    }

    public String getTaskPctDone() {
        return taskPctDone;
    }

    public void setTaskPctDone(String taskPctDone) {
        this.taskPctDone = taskPctDone;
    }

    
    public String getLearnerNo() {
        return learnerNo;
    }

    public void setLearnerNo(String learnerNo) {
        this.learnerNo = learnerNo;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
        
}
