package com.example.homework15.service;

import com.example.homework15.exception.*;
import com.example.homework15.model.Employee;
import com.example.homework15.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirmService {

    private List<Employee> employeesList;

    public FirmService() {
        employeesList = new ArrayList<>();
//        Person p = new Person("Yoana", 24, "Sofiq");
//        Employee emp = new Employee(1, 3000, p);
//        employeesList.add(emp);
    }

    public List<Employee> findAll(){
        if (employeesList.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        return employeesList;
    }

    public Employee addEmployee(Employee emp){
        if(emp.getId() == 0){
            throw new EmployeeMissingIdException();
        }
        if(emp.getPersonInfo().getName() == null){
            throw new NoNameRepresentedException();
        }
        if (emp.getSalary() == 0){
            throw new NoSalaryAddedException();
        }
        if (emp.getSalary() < 0){
            throw new NegativeSalaryException();
        }
        for (Employee employee : employeesList) {
            if(employee.getId() == emp.getId()){
                throw new ExistingEmployeeException();
            }
        }
        employeesList.add(emp);
        return emp;
    }

    public Employee findById(int id){
        for (Employee employee : employeesList) {
            if(employee.getId() == id){
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee deleteById(int id){
       for (Employee employee : employeesList) {
            if(employee.getId() == id){
                employeesList.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
        public Employee updateById(int id, Employee emp){
        for (Employee employee : employeesList) {
            if (employee.getId() == id){
                employee.setSalary(emp.getSalary());
                employee.setPersonInfo(emp.getPersonInfo());
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }


}
