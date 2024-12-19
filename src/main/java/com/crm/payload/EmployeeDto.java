package com.crm.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data //We can use @Data rather than using @Getter and @Setter.
public class EmployeeDto {
    private Long id;

    @NotBlank
    @Size(min =3, message ="At least 3 characters required")
    private String name;

    @Email
    private String emailId;

    @Size(min =10, max =10, message ="should be 10 digits")
    private String mobile;

   // private Date date;
}
