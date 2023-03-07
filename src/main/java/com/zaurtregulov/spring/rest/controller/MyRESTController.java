package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // это Controller который управляет REST запросами и ответами
@RequestMapping("/api") // с этого будет начинаться URL
public class MyRESTController {
    @Autowired // просит Spring Bean подставить значение
    private EmployeeService employeeService;

    @GetMapping("/employees")  //тоже самое что RequestMapping только специализированно под GEТ запрос
    public List<Employee> showAllEmployees(){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }



















}
