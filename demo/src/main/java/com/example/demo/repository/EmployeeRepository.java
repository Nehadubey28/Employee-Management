package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);

    //select * from table where name="machi" AND location="MP";
    List<Employee> findByNameAndLocation(String name,String location);

    //select * from table where name LIKE "%ram%"
    List<Employee> findByNameContaining(String keyword, Sort sort);

}
