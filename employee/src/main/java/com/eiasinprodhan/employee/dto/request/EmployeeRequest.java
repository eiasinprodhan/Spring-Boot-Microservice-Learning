package com.eiasinprodhan.employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeRequest {
    private String name;
    private String email;
    private String code;
    private String companyName;
}
