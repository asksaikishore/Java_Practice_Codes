package org.example.Controller;

import org.example.Repository.DepartmentRepository;
import org.example.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

//    @GetMapping("/field/{field}")
//    public Department getDepartmentByField(@PathVariable String field) {
//        return departmentRepository.findByField(field);
//    }   //We can use any one below or this , we use pathvariable only when we provide unique ID
    @GetMapping("/field")
    public Department getDepartmentByField(@RequestParam String field) {
        return departmentRepository.findByField(field);
    }
    @GetMapping("/fields")
    public List<String> getAllDepartmentFields(){
        return departmentRepository.findAll().stream().map(Department::getField).collect(Collectors.toList());
    }
}

