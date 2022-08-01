package com.yojik.spring.springboot.spring_data_jpa.controller;


import com.yojik.spring.springboot.spring_data_jpa.entity.Employee;
import com.yojik.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

//        if (employee == null) throw new NoSuchEmployeeException("There no Employee with this " +
//                "ID = " + id + " in database");
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if (getEmployee(id) != null) {
            employeeService.deleteEmployee(id);
        }
        return "Employee with id " + id + " was erased";
    }

    @GetMapping("/employees/name_starts_with/{nameStartsWith}")
    public  List<Employee> showAllEmployeesNameStartsWith(@PathVariable("nameStartsWith") String nameStartsWith) {
        List<Employee> employees = employeeService.findAllByNameStartsWith(nameStartsWith);
        return  employees;

    }

}
