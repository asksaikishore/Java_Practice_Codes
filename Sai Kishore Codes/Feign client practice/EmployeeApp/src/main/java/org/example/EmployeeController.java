package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        List<String> FieldNames = employeeService.getFieldsfromDept();
        model.addAttribute("fields", FieldNames);
        return "new-employee";
    }
    @PostMapping("/all")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/all";
    }

    @GetMapping("/{employeeId}/department")
//    public Long getDepartmentId(@PathVariable Long employeeId) {
//        return employeeService.getDepartmentIdByEmployeeId(employeeId);
//    }
    public ResponseEntity<Long> getDepartmentId(@PathVariable Long employeeId) {
        Long departmentId = employeeService.getDepartmentIdByEmployeeId(employeeId);
        return ResponseEntity.ok(departmentId);
    }
    @GetMapping("/all")
    public String finde(Model model){

        List<Employee> employees=employeeService.findEmp();
        model.addAttribute("employees", employees);
        return "employees";
    }
    @GetMapping("/fields")
    public ResponseEntity<List<String>> getDeptFields(){
        return ResponseEntity.ok(employeeService.getFieldsfromDept());

    }}
