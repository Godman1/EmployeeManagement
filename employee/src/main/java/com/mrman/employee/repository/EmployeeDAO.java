package com.mrman.employee.repository;

import com.mrman.employee.entity.Employee;
import com.mrman.employee.storage.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

    private static Employees list = new Employees();

    static{
        list.getEmployeeList().add(
                new Employee(
                        1,
                        "Prem",
                        "Tiwari",
                        "hr",
                        "chapradreams@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        2,
                        "Vikash",
                        "Kumar",
                        "retention",
                        "abc@gmail.com"));


        list.getEmployeeList().add(
                new Employee(
                        3,
                        "Ritesh",
                        "Ojha",
                        "manager",
                        "asdjf@gmail.com"));
    }
    public Employees getAllEmployees()
    {

        return list;
    }

    public void
    addEmployee(Employee employee)
    {
        list.getEmployeeList()
                .add(employee);

    }

}
