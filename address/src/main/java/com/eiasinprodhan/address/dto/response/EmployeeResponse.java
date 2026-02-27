package com.eiasinprodhan.address.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String code;
    private String companyName;
}
