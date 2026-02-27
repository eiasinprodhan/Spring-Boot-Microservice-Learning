package com.eiasinprodhan.address.dto.request;

import com.eiasinprodhan.address.entity.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest {

    private Long employeeId;
    private String street;
    private Long zipCode;
    private String city;
    private String country;
    private AddressType addressType;
}
