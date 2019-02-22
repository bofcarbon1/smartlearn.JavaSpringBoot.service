
package com.spring.smartlearn.controllers;

import com.spring.smartlearn.models.Task;
import com.spring.smartlearn.models.TaskNew;
import com.spring.smartlearn.repositories.TaskIRepository;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.spring.smartlearn.models.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bofcarbon1
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/task")
public class TaskController {
    
    @Autowired            
    TaskIRepository taskRepository;
  
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        List<Task> taskList = null; 
        try{
            taskList = taskRepository.findAll();        
        }catch(Exception e){
            System.out.println(e);             
        }   
        return taskList;
    }
    
    @RequestMapping(value = "/selects", method = RequestMethod.GET)
    public List<String> getTaskSelects() {
        List<String> taskList = null; 
        try{
            taskList = taskRepository.findtaskNoAndtaskName();        
        }catch(Exception e){
            System.out.println(e);             
        }   
        return taskList;
    }
    
    @RequestMapping(value = "/ById/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") ObjectId id) {
        return taskRepository.findBy_id(id);
    }
    
    @RequestMapping(value = "/ByFilter/{filter}", method = RequestMethod.GET)
    public List<Task> getTaskByFilter(@PathVariable("filter") String filter) {
        return taskRepository.findBytaskNameLike(filter);
    }
    
    @RequestMapping(value = "/ByProject/{projectNo}", method = RequestMethod.GET)
    public List<Task> getTaskByProjectNo(@PathVariable("projectNo") String projectNo) {
        List<Task> tasks = taskRepository.findByprojectNoLike(projectNo);
        System.out.println("getTasksByProjectNo: projectNo: " + projectNo);
        System.out.println("getTasksByProjectNo: tasks size: " + tasks.size());
        return tasks; 
    }
     
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public String modifyTaskById(@Valid @RequestBody Task task) {
        ObjectId id = task._id;
        task.setId(id);
        System.out.println("modifyTaskById: task.learnerNo: " + task.learnerNo);
        taskRepository.save(task);
        return "200";
    }
    
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String createTask (@RequestBody TaskNew taskNew) {
        Task task = new Task();
        task.setId(ObjectId.get());
        task.taskNo = taskNew.taskNo;
        task.projectNo = taskNew.projectNo;
        task.lessonNo = taskNew.lessonNo;
        task.learnerNo = taskNew.learnerNo;                
        task.taskName = taskNew.taskName;
        task.taskDesc = taskNew.taskDesc;
        task.taskPctDone = taskNew.taskPctDone;
        taskRepository.save(task);
        return "200";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteTask (@PathVariable ObjectId id) {
        taskRepository.delete(taskRepository.findBy_id(id));
        return "200";
    }
    
}
