
package com.spring.smartlearn.repositories;

import com.spring.smartlearn.models.Task;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author bofcarbon1
 */

public interface TaskIRepository extends MongoRepository<Task, String> {
    List<Task> findAll();
    Task findBy_id(ObjectId _id);
    List<Task> findBytaskNameLike(String filter);
    List<Task> findByprojectNoLike(String taskNo);
    @Query(value="{}", fields="{taskNo : 1, taskName : 1, _id : 0}")
    List<String> findtaskNoAndtaskName();
}
