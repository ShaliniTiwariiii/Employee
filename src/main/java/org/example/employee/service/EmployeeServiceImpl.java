package org.example.employee.service;

import org.example.employee.dto.EmployeeDTO;
import org.example.employee.dto.EmployeeDTORequest;
import org.example.employee.model.Employee;
import org.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
         public List<EmployeeDTO> fetchAllEmployees(Pageable pageable,String search){
             Page<Employee> employeePage;
             if(search==null||search.trim().isEmpty()){
                employeePage= employeeRepository.findAll(pageable);
             }else{
                 employeePage= employeeRepository.findByNameContainingIgnoreCase(search,pageable);
             }
             return employeePage.stream().map(this::convertToDTO).toList();
         }
         private EmployeeDTO convertToDTO(Employee employee){
             EmployeeDTO dto = new EmployeeDTO();
             dto.setId(employee.getId());
             dto.setName(employee.getName());
             dto.setDept(employee.getDept());
             return dto;
         }
         public EmployeeDTO createEmployee(EmployeeDTORequest request){
         Employee employee = new Employee();
         employee.setName(request.getName());
         employee.setDept(request.getDept());
         employee.setJoiningDate(request.getJoiningDate());
         Employee savedEmployee=employeeRepository.save(employee);
         EmployeeDTO dto= new EmployeeDTO();
            dto.setId(savedEmployee.getId());
            dto.setName(savedEmployee.getName());
            dto.setDept(savedEmployee.getDept());
            return dto;
         }

}
