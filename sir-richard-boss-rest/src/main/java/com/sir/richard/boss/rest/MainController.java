package com.sir.richard.boss.rest;

import com.sir.richard.boss.model.data.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    public List<Employee> all() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("name1", "role1"));
        return employeeList;
    }
}
