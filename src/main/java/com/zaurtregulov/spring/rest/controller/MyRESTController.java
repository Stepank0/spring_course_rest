package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.zaurtregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // это Controller который управляет REST запросами и ответами
@RequestMapping("/api") // с этого будет начинаться URL
public class MyRESTController {
    @Autowired // просит Spring Bean подставить значение
    private EmployeeService employeeService;

    @GetMapping("/employees")  //тоже самое что RequestMapping только специализированно под GEТ запрос
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        // @PathVariable int id - используется для  получения значения переменной из адреса запроса
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " int Database");
        }

        return employee;
    }

    // @PostMapping связывает HTTP запрос , использующий HTTP метод POST с методом контролера
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        //@RequestBody используется для добавления информации в теле POST request которое получаем с Клиента
        employeeService.saveEmployee(employee);
        return employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id +
                    " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";

    }


}
