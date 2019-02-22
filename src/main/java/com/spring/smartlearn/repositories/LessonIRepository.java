package com.spring.smartlearn.repositories;

import com.spring.smartlearn.models.Lesson;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author bofcarbon1
 */

public interface LessonIRepository extends MongoRepository<Lesson, String>{
    List<Lesson> findAll();
    Lesson findBy_id(ObjectId _id);
    List<Lesson> findBycourseNoLike(String courseNo);    
}
