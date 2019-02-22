
package com.spring.smartlearn.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author bofcarbon1
 */

public class Project {
    @Id
    public ObjectId _id;
    public String projectNo;
    public String projectName;
    public String projectDesc;
    
    public Project() {
    
    }
    
    public Project(ObjectId _id, String projectNo, String projectName, 
              String projectDesc) {
        this._id = _id;
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
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
