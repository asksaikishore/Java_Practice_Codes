package org.example.Repository;

import org.example.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByField(String field);
}
