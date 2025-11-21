package com.emp.web.app.employee.management.web.app.backend.repository;
import com.emp.web.app.employee.management.web.app.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
