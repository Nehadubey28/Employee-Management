package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotBlank(message = "name should not me blank")
    @NotEmpty(message = "name should not be empty")
    @NotNull(message="name should not be null")
    @Column(name="name")
    private String name ;

    @Column(name="age")
    private Long age;

    @Column(name="location")
    private String location;

    @Email(message = "should be in valid format")
    @Column(name="email")
    private String email;

    @NotBlank(message = "department should not me blank")
    @NotEmpty(message = "department should not be empty")
    @Column(name="department")
    private String department;

    /*@CreationTimestamp
    @Column(name="created_At",nullable = false,updatable = false)
    private Date createAt;

    @UpdateTimestamp
    @Column(name="update_At")
    private Date updateAt;*/

}
