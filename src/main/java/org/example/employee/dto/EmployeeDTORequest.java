package org.example.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTORequest {


    private String name;
    private String dept;
    private Date joiningDate;
}
