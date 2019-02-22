
package com.spring.smartlearn.repositories;

import com.spring.smartlearn.models.Project;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author bofcarbon1
 */

public interface ProjectIRepository  extends MongoRepository<Project, String>{
    List<Project> findAll();
    Project findBy_id(ObjectId _id);
    List<Project> findByprojectNameLike(String filter);
    List<Project> findByprojectNoLike(String projectNo);        
}
