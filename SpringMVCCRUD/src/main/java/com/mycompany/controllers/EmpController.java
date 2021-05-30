package com.mycompany.controllers;   
import java.util.ArrayList;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.beans.Emp;
import com.mycompany.dao.EmpDao;  
@Controller  
public class EmpController {  
    @Autowired  
    EmpDao dao;//will inject dao from xml file  
     
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index2";
    }
    
    @ModelAttribute("foodList")
    public List<String> getWebFrameworkList() {
       List<String> webFrameworkList = new ArrayList<String>();
       webFrameworkList.add("Indian");
       webFrameworkList.add("Thai");
       webFrameworkList.add("Chineese");
       webFrameworkList.add("Continental");
       return webFrameworkList;
    }
    
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	Emp e =new Emp();
    	e.setFood(new String[] {"Indian","Thai","Continental"});
    	m.addAttribute("command", e);
    	return "empform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Emp emp){  
        dao.save(emp);  
        return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Emp> list=dao.getEmployees();  
        m.addAttribute("list",list);
        return "viewemp";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Emp emp=dao.getEmpById(id);  
        m.addAttribute("command",emp);
        //m.addAttribute("selectedFoodList",emp.getFood());
        return "empeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
        return "redirect:/viewemp";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewemp";  
    }   
}  