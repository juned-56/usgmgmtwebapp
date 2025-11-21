package com.emp.web.app.employee.management.web.app.backend.service;
import com.emp.web.app.employee.management.web.app.backend.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee addNewEmployee(Employee emp);
    public Employee updateEmployee(long id, Employee emp);
    public List<Employee> getAllEmployess();
    public Optional<Employee> getEmployeeById(long id);
    public void deleteEmployee(long id);
}
