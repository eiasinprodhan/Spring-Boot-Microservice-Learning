package com.eiasinprodhan.address.client;

import com.eiasinprodhan.address.dto.response.EmployeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employeeClient", url = "${employee.service.url}")
public interface EmployeeClient {

    @GetMapping("/{id}")
    EmployeeResponse getEmployee(@PathVariable Long id);

}
