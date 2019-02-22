smartlearn - Java Spring Boot service
=====================================

This is a back end service written in Java Spring Boot
with a MongoRepository option. Its primary purpose is to
provide data access services to a mongoDB database for
all data needed to run the smartlearn React web app that
is a web based SPA used for training. 

Java features used in this app
 . org.springframework.boot
 . org.springframework.beans.factory.annotation
 . org.springframework.web.bind.annotation 
 . org.springframework.data.annotation (mongodb)
 . org.springframework.data.mongodb (mongodb)
 . com.spring
 . java 1.8 (java)
 . spring-boot-start-data-mongodb (mongodb)
 . org.assertj (test)
 . com.googlecode.json-simple (java objects)
 . com.googlecode.gson-simple (java objects)
 
Java tools used to test this app
 . SpringRunner
 . SpringBootTest

Testing was performed on selected methods
using a standard TDD format of Setup/Action/Assert
much like JUnit and NUnit in .NET Web API/WCF. 
see test/java/com/spring/smartlearn/SmartlearnApplicationTests.java.

Application Features

 . src/main/java/com/spring/smartlearn   
   . SmartLearnApplication.java 
    uses the @SpringBootApplication to run out application from main

 . src/main/java/com/spring/smartlearn/controllers
   @CrossOrigin(origins, @RestController, @RequestMapping(), RequestMethod
   All files below take http request and respond as json or convertible objects
   . CourseControler.java
   . LearnerController.java
   . LessonController.java
   . ProjectControler.java
   . TaskControler.java

. src/main/java/com/spring/smartlearn/models/
   Java class models used to represent data (mongoDB)
   specifically ObjectId (org.bson.types.ObjectId)
   . Course.java
   . Learner.java
   . Lesson.java
   . Project.java
   . Task.java  

. src/main/java/com/spring/smartlearn/repositories
  This is where the repository extension for mongoDB magic occurs
  using the two library files mentioned below  
  org.springframework.data.mongodb.repository.MongoRepository;
  org.springframework.data.mongodb.repository.Query;  
  This is an interface class with a 'MongoRepository' extension
  passing our model references mentioned in the section above. 
  Inside of the interfaces (below) you can construct keyword 
  combinations of methods that in combination with signature
  arguments utilize an underlying matching method in repository
  library that simulates mongo commands against a mongoDB database.

  this example this line will return all documents from a 'Course' collection
  
  'List<Course> findAll();'

  this example returns documents from a 'Course' collection that match a string
  filter in name items in documents 
  
  'List<Course> findBycourseNameLike(String filter);' 
 
  . CourseIRepository.java
  . LearnerIRepository.java
  . LessonIRepository.java
  . ProjectIRepository.java
  . TaskIRepository.java

Data

We store out data in a mongoDB database. This was
a locally installed version of mongoDB. We use Robo 3T 
formally RoboMongo as our mongoDB admin tool. Our mongoDB
database is launched from a line command 'mongod ' or 
'mongod --nojournal'. It is reached through a URL connection
in Java and configured in 

file src/main/resources/application.properties
adding these lines...

spring.data.mongodb.database=smartlearn
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017

Our mongoDB collections/documents (samples)
. Courses
{
    "_id" : ObjectId("5c49622e8f1dc1711ce33b0d"),
    "courseNo" : " 1001",
    "courseName" : " mongoDB",
    "courseDesc" : " Learn how to work with mongoDB in web apps",
    "_class" : "com.spring.smartlearn.models.Course"
}

. Lessons
{
    "_id" : ObjectId("5c4ac9508f1dc180b4b0e5b2"),
    "lessonNo" : " 1",
    "courseNo" : " 1001",
    "lessonName" : "Install mongoDB ",
    "lessonDesc" : "Install mongoDB, configure and start it. Verify that it can be accessed.  ",
    "projectNo" : "10011",
    "taskNo" : "100111",
    "_class" : "com.spring.smartlearn.models.Lesson"
}


. Learners
{
    "_id" : ObjectId("5c3be51e43a37985461c722b"),
    "learnerNo" : "L001",
    "learnerName" : "Brian Quinn",
    "learnerNote" : "Brian is currently learning React, Java Spring Boot with mongoDB reppository",
    "_class" : "com.spring.smartlearn.models.Learner"
}

. Projects
{
    "_id" : ObjectId("5c1f3fe25a622c6fd7f96a1d"),
    "projectNo" : "10011",
    "projectName" : "SmartLearn App",
    "projectDesc" : "Smart Learn a training app in React, Java, mongoDB ",
    "_class" : "com.spring.smartlearn.models.Project"
}

. Tasks
{
    "_id" : ObjectId("5c1f42aa5a622c6fd7f96a1e"),
    "taskID" : "1",
    "lessonID" : "1",
    "learnerID" : "1",
    "taskName" : "Create database smartlearn",
    "taskDescription" : "Create a mongoDB database called smartlearn with collections course, learner, lesson, project and task with initial documents"
}
    


