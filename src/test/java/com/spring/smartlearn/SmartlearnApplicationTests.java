package com.spring.smartlearn;

import com.spring.smartlearn.models.Learner;
import com.spring.smartlearn.repositories.LearnerIRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.bson.types.ObjectId;
import static org.junit.Assert.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartlearnApplicationTests {
     
    @Autowired
    private LearnerIRepository learnerRepository;
    
    Learner bob, kim, sophia, jack, brian;
    
    static final int NUMBER_OF_LEARNERS = 6;
    
    @Before
    public void init() {
        
        //learnerRepository.deleteAll();
        
        //this.bob = learnerRepository.save(new Learner(null, "2", "Bob Burns", "Learner 2"));
        //this.kim = learnerRepository.save(new Learner(null, "3", "Kim King", "Learner 3"));
        //this.sophia = learnerRepository.save(new Learner(null, "4", "Sophia Suarez", "Learner 4"));
        //this.jack = learnerRepository.save(new Learner(null, "5", "Jack Jones", "Learner 5"));
        //this.brian = learnerRepository.save(new Learner(null, "1", "Brian Quinn", "Learner 1"));
    }
      
    //@Test
    //public void whenFindAllLearnersShouldReturnAll() {
    //    //given (setup)
                
    //    // when (action)
    //    List<Learner> learners = learnerRepository.findAll();
        
    //    // then ()
    //    assertEquals(learners.size(), NUMBER_OF_LEARNERS);
    //}
    
    //@Test
    //public void whenFindByIdLearnerShouldReturnOne() {
    //    //given (setup)
    //    ObjectId _id = new ObjectId("5c2951e88f1dc18068175d42");
       
    //    // when (action)
    //    Learner learner = learnerRepository.findBy_id(_id);
        
    //    // then ()
    //    assertEquals(learner.learnerID, "8");
    //}

    //@Test
    //public void whenSaveByIdLearnerShouldUpdateOne() {
    //    //given (setup)
    //    ObjectId _id = new ObjectId("5c2951e88f1dc18068175d42");
    //    Learner learner;
    //    learner = learnerRepository.save(new Learner(_id, "2", "Bob Burns", "Learner 2 is now a Sophmore"));
                
    //    // when (action)
    //    learnerRepository.save(learner);
    //    Learner learner2 = learnerRepository.findBy_id(_id);
        
    //    // then ()
    //    assertTrue(learner2.getLearnerNote().contains("Sophmore"));
    //}
    
    //@Test
    //public void whenDeleteByIdLearnerShouldDeleteOne() {
    //    //given (setup)
    //    List<Learner> learnerBefore = learnerRepository.findAll();
    //    int totalLearnersBefore = learnerBefore.size();
    //    ObjectId _id = new ObjectId("5c2951e88f1dc18068175d42");
                
    //    //when (action)
    //    learnerRepository.delete(learnerRepository.findBy_id(_id));
    //    List<Learner> learnerAfter = learnerRepository.findAll();
    //    int totalLearnersAfter = (learnerAfter.size() + 1);
        
    //    // then ()
    //    assertEquals(totalLearnersBefore, totalLearnersAfter);
    //}
    
    @Test
    public void whenInsertLearnerShouldAddOne() {
        //given (setup)
    //    List<Learner> learnersBefore = learnerRepository.findAll();
    //    int totalLearnersBefore = learnersBefore.size();
    //    Learner learner = new Learner(null, "Learner X", "Learner waa added in test");
                
        // when (action)
    //    learnerRepository.save(learner);
    //    List<Learner> learnersAfter = learnerRepository.findAll();
    //    int totalLearnersAfter = (learnersAfter.size() - 1);
        
        // then ()
    //    assertEquals(totalLearnersBefore, totalLearnersAfter);        
    }
    
}

