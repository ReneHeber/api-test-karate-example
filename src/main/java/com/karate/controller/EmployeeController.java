package com.rkdevblog.karate.controller;

import com.rkdevblog.karate.dto.AllEmployeeResponseDto;
import com.rkdevblog.karate.dto.EmployeeResponseDto;
import com.rkdevblog.karate.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setName(employee.getName());
        employeeResponseDto.setMessage("Successfully created employee");
        return ResponseEntity.ok(employeeResponseDto);
    }

    @GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable int id) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setName("john");
        employeeResponseDto.setMessage("Successfully returned employee");
        if (id != 1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllEmployees() {

        Employee employee = new Employee();
        employee.setId("emp-1");
        employee.setName("john");
        employee.setAddress("winterfell");
        employee.setEmail("john@gmail.com");

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            employees.add(employee);
        }

        AllEmployeeResponseDto allEmployeeResponseDto = new AllEmployeeResponseDto();
        allEmployeeResponseDto.setEmployees(employees);

        return new ResponseEntity<>(allEmployeeResponseDto, HttpStatus.OK);
    }


}
