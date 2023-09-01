package com.mrityunjay.employeemanager.service;
import java.util.*;

import com.mrityunjay.employeemanager.exception.UserNotFoundException;
import com.mrityunjay.employeemanager.model.Employee;
import com.mrityunjay.employeemanager.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {


    private final EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee addEmployee(Employee employee){

        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }





    public List<Employee>  findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return  employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User By Id" + id + "was not found"));

    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

}
