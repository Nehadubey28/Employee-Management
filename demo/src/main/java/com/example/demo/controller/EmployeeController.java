package com.example.demo.controller;

import com.example.demo.model.Employee;

import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
   // @RequestMapping(value="/Test",method = RequestMethod.GET)

    @Autowired
    private EmployeeService eservice;

   @Value("${app.name}")
   private String appName;
   @Value("${app.version}")
   private String appVersion;
   @GetMapping("/version")
   public String getAppDetails(){
       return "AppName:"+appName+"AppVersion:"+appVersion;
   }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployee(){
        return new ResponseEntity<List<Employee>>(eservice.getEmployee(),HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return eservice.getSingleEmployee(id);
    }
    //localhost:8080/Employees?id=1
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id){
        eservice.deleteEmployee(id);
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody  Employee employee){
        return eservice.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
       employee.setId(id);
        return eservice.updateEmployee(employee);
    }


    //localhost:8080/employees/filterByNameAndLoction?name=sachi&location=kulu
    @GetMapping("/employees/filterByNameAndLoction")
    public ResponseEntity<List<Employee>> getEmployeeBylocation(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<List<Employee>>(eservice.getEmployeeByNameAndLocation(name,location),HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeeBylocation(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eservice.getEmployeeByKeyword(name),HttpStatus.OK);
    }

    //localhost:8080/employess/test?pagenumber=0&pageSize=5
    @GetMapping("/employees/test")
    public List<Employee> getEmployeeBypageable(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
       return eservice.getEmployeePaging(pageNumber,pageSize);
    }


}
