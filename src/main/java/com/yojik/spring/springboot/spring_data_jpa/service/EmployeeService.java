package com.yojik.spring.springboot.spring_data_jpa.service;



import com.yojik.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

//    List<String> getDepartments();

   void saveOrUpdateEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
