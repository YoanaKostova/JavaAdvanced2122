package com.example.homework15.controllers;

import com.example.homework15.exception.*;
import com.example.homework15.model.Employee;
import com.example.homework15.model.ErrorDetails;
import com.example.homework15.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirmController {

    @Autowired
    FirmService firmService;

    @GetMapping("/employees")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(200).body(firmService.findAll());
        } catch (EmployeeNotFoundException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("The list of employees is empty!");
            return ResponseEntity.badRequest().body(errorDetails);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(firmService.findById(id));
        } catch (EmployeeNotFoundException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Employee not found!");
            return ResponseEntity.badRequest().body(errorDetails);
        }
    }

    @GetMapping("/delEmployees/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(firmService.deleteById(id));
        } catch (EmployeeNotFoundException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Employee not found!");
            return ResponseEntity.badRequest().body(errorDetails);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
        try {
            return ResponseEntity
                    .ok()
                    .body(firmService.addEmployee(emp));
        } catch (NoNameRepresentedException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("No name represented!");
            return ResponseEntity.badRequest().body(errorDetails);
        } catch (NoSalaryAddedException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("No salary added!");
            return ResponseEntity.badRequest().body(errorDetails);
        } catch (NegativeSalaryException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Negative salary was added!");
            return ResponseEntity.badRequest().body(errorDetails);
        } catch (EmployeeMissingIdException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Missing Employee ID!");
            return ResponseEntity.badRequest().body(errorDetails);
        } catch (ExistingEmployeeException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Employee already exist!");
            return ResponseEntity.badRequest().body(errorDetails);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        try {
            return ResponseEntity.ok().body(firmService.updateById(id, emp));
        } catch (EmployeeNotFoundException e){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Employee not found!");
            return ResponseEntity.badRequest().body(errorDetails);
        }
    }

}
