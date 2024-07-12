package org.example.service;

import org.example.Client.DepartmentClient;
import org.example.Exception.ResourceNotFoundException;
import org.example.Repository.EmployeeRepository;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentClient departmentClient;

    public Long getDepartmentIdByEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        Department department = departmentClient.getDepartmentByField(employee.getField());
        return department.getDepartmentId();
    }
    public List<Employee> findEmp(){

        return employeeRepository.findAll();
    }
    public List<String> getFieldsfromDept(){
        return departmentClient.getAllDepartmentFields();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
