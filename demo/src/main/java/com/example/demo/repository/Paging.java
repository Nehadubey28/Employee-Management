package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Paging extends PagingAndSortingRepository<Employee,Long> {

}
