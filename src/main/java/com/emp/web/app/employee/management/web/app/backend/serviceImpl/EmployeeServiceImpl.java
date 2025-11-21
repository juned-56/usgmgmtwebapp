package com.emp.web.app.employee.management.web.app.backend.serviceImpl;

import com.emp.web.app.employee.management.web.app.backend.exception.ResourceNotFoundException;
import com.emp.web.app.employee.management.web.app.backend.model.Employee;
import com.emp.web.app.employee.management.web.app.backend.repository.EmployeeRepository;
import com.emp.web.app.employee.management.web.app.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addNewEmployee(Employee emp) {
       return employeeRepository.save(emp);
    }

    @Override
    public Employee updateEmployee(long id, Employee emp) {
        Optional<Employee> employee = getEmployeeById(id);
        if(employee.isPresent()){
           Employee existingEmployee = employee.get();
           existingEmployee.setFirstName(emp.getFirstName());
           existingEmployee.setLastName(emp.getLastName());
           existingEmployee.setEmail(emp.getEmail());
            return employeeRepository.save(existingEmployee);
        }else {
            throw new ResourceNotFoundException("Employee not found");
        }
    }

    @Override
    public List<Employee> getAllEmployess() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee;
        }else {
            throw new ResourceNotFoundException("Employee Not found");
        }
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
