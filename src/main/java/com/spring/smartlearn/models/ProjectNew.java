
package com.spring.smartlearn.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bofcarbon1
 */

public class ProjectNew {
    public String projectNo;
    public String projectName;
    public String projectDesc;

    public ProjectNew() {
    
    }
    
    public ProjectNew(String projectNo, String projectName, 
              String projectDesc) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }
    
    
}