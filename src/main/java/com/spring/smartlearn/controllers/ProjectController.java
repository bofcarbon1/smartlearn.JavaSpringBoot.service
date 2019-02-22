
package com.spring.smartlearn.controllers;

import com.spring.smartlearn.models.Project;
import com.spring.smartlearn.models.ProjectNew;
import com.spring.smartlearn.repositories.ProjectIRepository;
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
@RequestMapping("api/project")
public class ProjectController {
    
    @Autowired            
    ProjectIRepository projectRepository;
  
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> getAllProjects() {
        List<Project> projectList = null; 
        try{
            projectList = projectRepository.findAll();        
        }catch(Exception e){
            System.out.println(e);             
        }   
        return projectList;
    }
    
//    @RequestMapping(value = "/projectNos", method = RequestMethod.GET)
//    public List<String> getAllProjectNos() {
//        List<String> projectList = null;        
//        try{
//            projectList = projectRepository.findprojectNo();             
//        }catch(Exception e){
//            System.out.println(e);            
//        }   
//        return projectList;
//    }
    
    @RequestMapping(value = "/ById/{id}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable("id") ObjectId id) {
        return projectRepository.findBy_id(id);
    }
    
    @RequestMapping(value = "/ByFilter/{filter}", method = RequestMethod.GET)
    public List<Project> getProjectByFilter(@PathVariable("filter") String filter) {
        return projectRepository.findByprojectNameLike(filter);
    }
    
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
    public String modifyProjectById(@Valid @RequestBody Project project) {
        ObjectId id = project._id;
        project.setId(id);
        projectRepository.save(project);
        return "200";
    }
    
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String createProject (@RequestBody ProjectNew projectNew) {
        Project project = new Project();
        project.setId(ObjectId.get());
        project.projectNo = projectNew.projectNo;
        project.projectName = projectNew.projectName;
        project.projectDesc = projectNew.projectDesc;
        projectRepository.save(project);
        return "200";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProject (@PathVariable ObjectId id) {
        projectRepository.delete(projectRepository.findBy_id(id));
        return "200";
    }
}
