package com.stackdevs.EMS.employee;

import com.stackdevs.EMS.util.SharedMethods;
import com.stackdevs.EMS.util.constants.AppConstants;
import com.stackdevs.EMS.util.exceptions.DataConflictException;
import com.stackdevs.EMS.util.exceptions.InvalidOperationException;
import com.stackdevs.EMS.util.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) throws UserNotFoundException {
        log.debug("Attempting to fetch user with id="+id);
        Optional<Employee>  employeeOptional = this.employeeRepository.findById(id);
        if (employeeOptional.isEmpty())
            throw new UserNotFoundException("No user found with id="+id);
        return employeeOptional.get();
    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pg) {
        log.debug("Attempting to retrieve all users");
        return this.employeeRepository.findAll(pg);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // validate that we dont have an email conflicts
        boolean isValidEmail = userExistByEmail(employee.getEmail());
        if (isValidEmail){
            log.debug("New user successfully created");
            return this.employeeRepository.save(employee);
        }
        String error = String.format("%s is already taken",employee.getEmail());
        throw new DataConflictException(error);
    }

    @Override
    public void removeEmployee(Long id) {
        Employee employee  = getEmployeeById(id);
        employee.setIntrash(AppConstants.INTRASH_YES);
        saveEmployee(employee);
        log.debug("Successfully removed user with id "+id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
       Employee existing = getEmployeeById(employee.getId());
       boolean isEmployeeModified = SharedMethods.compareObjects(existing,employee);
       if (isEmployeeModified){
           saveEmployee(employee);
       }
       throw new InvalidOperationException("Employee record have not been modified");
    }

    private boolean userExistByEmail(String email) throws DataConflictException {
        return this
                .employeeRepository
                .findEmployeeByEmailAndIntrash(email, AppConstants.INTRASH_NO)
                .isEmpty();
    }
}
