package org.example.employee.service;

import org.example.employee.dto.EmployeeDTO;
import org.example.employee.dto.EmployeeDTORequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> fetchAllEmployees(Pageable pageable, String search);
    EmployeeDTO createEmployee(EmployeeDTORequest employeeDTORequest);
}
