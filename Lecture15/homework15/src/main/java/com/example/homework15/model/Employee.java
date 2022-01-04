package com.example.homework15.model;

public class Employee {
    private int id;
    private double salary;
    private Person personInfo;

    public Employee() {
    }
    public Employee(int id, double salary, Person personInfo) {
        this.id = id;
        this.salary = salary;
        this.personInfo = personInfo;
    }

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(Person personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", personInfo=" + personInfo +
                "}\n";
    }
}
