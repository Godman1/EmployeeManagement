package com.mrman.employee.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrman.employee.controller.EmployeeController;
import com.mrman.employee.entity.Employee;
import com.mrman.employee.repository.EmployeeDAO;
import com.mrman.employee.storage.Employees;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    EmployeeDAO employeeDAO;

    Employee EMPLOYEE_1= new Employee(1, "jade", "Tiwa", "Data analytics", "jadeti@gmail.com");
    Employee EMPLOYEE_2= new Employee(2, "duboir", "sardis", "Software engineer", "duboirsass@gmail.com");
    Employee EMPLOYEE_3= new Employee(3, "elijah", "fire", "designer", "wolfup@gmail.com");


    public void getAllEmployee()throws Exception{
        List<Employee> employees = new ArrayList<>(Arrays.asList(EMPLOYEE_1,EMPLOYEE_2,EMPLOYEE_3));

        Mockito.when(employeeDAO.getAllEmployees()).thenReturn((Employees) employees);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect((ResultMatcher) jsonPath("$[2].name", is("elijah fire")));

    }


}
