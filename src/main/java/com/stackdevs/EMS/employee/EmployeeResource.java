package com.stackdevs.EMS.employee;

import com.stackdevs.EMS.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<CustomResponse<Page<Employee>>> getEmployees(Pageable pg){
        logger.debug("Get Employees handler function invoked.");
        CustomResponse<Page<Employee>> response = CustomResponse
                .<Page<Employee>>builder()
                .data(this.employeeService.getAllEmployees(pg))
                .message("Request is successful")
                .code(HttpStatus.OK.value())
                .build();
        // log the operation to audit trails
        return ResponseEntity.ok(response);
    }

}
