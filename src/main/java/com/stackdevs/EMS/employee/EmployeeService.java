package com.stackdevs.EMS.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    /**
     * @notes used to fetch a single EMPLOYEE
     * @param id
     * @return
     */
    Employee getEmployeeById(Long id);
    /**
     * @notes get all employees
     * @return
     */
    Page<Employee> getAllEmployees(Pageable pg);

    /**
     * @notes save employee
     * @param employee instance to be saved
     * @return
     */
    Employee saveEmployee(Employee employee);

    /**
     * @notes remove an employee
     * @param id
     * @return
     */
    void removeEmployee(Long id);

    Employee updateEmployee(Employee employee);
}
