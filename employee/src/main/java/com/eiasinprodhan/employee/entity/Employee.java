package com.eiasinprodhan.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String code;
    private String companyName;

}
