package org.example.Client;

import org.example.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Department-app", url = "http://localhost:8081")
public interface DepartmentClient {
    @GetMapping("/departments/field")
    Department getDepartmentByField(@RequestParam("field") String field);

    @GetMapping("/departments/fields")
    List<String> getAllDepartmentFields();
}

