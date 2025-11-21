package com.emp.web.app.employee.management.web.app.backend.controller;
import com.emp.web.app.employee.management.web.app.backend.model.Employee;
import com.emp.web.app.employee.management.web.app.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee") //http://localhost:8787/app/v1/addEmployee
    public Employee addemployee(@RequestBody Employee emp){
        return employeeService.addNewEmployee(emp);
    }

    @PutMapping("/updateEmployee/{id}") //http://localhost:8787/app/v1/updateEmployee/{id}
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee emp){
        return employeeService.updateEmployee(id, emp);
    }

    @GetMapping("/getemployeeById/{id}") //http://localhost:8787/app/v1/getemployeeById/{id}
    public Optional<Employee> getEmployee(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getAllEmployee") //http://localhost:8787/app/v1/getAllEmployee
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployess();
    }

    @DeleteMapping("/deleteEmployee/{id}") //http://localhost:8787/app/v1/deleteEmployee/{id}
    public void deletEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }
}
