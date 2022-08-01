package com.yojik.spring.springboot.spring_data_jpa.service;


import com.yojik.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.yojik.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
    employeeRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
      Optional<Employee> optionalEmployee = employeeRepository.findById(id);
      if (!optionalEmployee.isPresent()){throw new NoSuchElementException();}
          return optionalEmployee.get();
    }

    @Override
    public List<Employee> findAllByNameStartsWith(String nameStartsWith) {
        List<Employee> employees = employeeRepository.findAllByNameStartsWith(nameStartsWith);
        return employees;
    }
}
