package org.example.employee.controller;

import org.example.employee.dto.EmployeeDTO;
import org.example.employee.dto.EmployeeDTORequest;
import org.example.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epmloyees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @GetMapping("/list")
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false,defaultValue = "1") int page,
                                          @RequestParam(required=false,defaultValue="10")int pageSize,
                                          @RequestParam(required = false,defaultValue = "id") String sortBy,
                                          @RequestParam(required=false,defaultValue = "asc") String sortDir,
                                          @RequestParam(required = false)String search) {
        Sort sort=null;
if(sortDir.equalsIgnoreCase("asc")){
sort=sort.by(sortBy).ascending();
}else{
    sort=sort.by(sortBy).descending();
}
return employeeService.fetchAllEmployees(PageRequest.of(page-1,pageSize,sort),search);
    }
    @PostMapping
public EmployeeDTO createEmployee(@RequestBody EmployeeDTORequest employeeDTORequest){
        return  employeeService.createEmployee(employeeDTORequest);
}

}
