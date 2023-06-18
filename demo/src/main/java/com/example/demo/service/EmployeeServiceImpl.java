package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository eRepository;

    @Autowired
    private Paging epaging;


    @Override
    public List<Employee> getEmployee() {
        return eRepository.findAll();
    }


    @Override
    public List<Employee> getEmployeePaging(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC,"id");
        return epaging.findAll(pages).getContent();
    }



    @Override
    public Employee saveEmployee(Employee employee) {
       return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee not found");
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee> getEmployeeByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return eRepository.findByNameContaining(name,sort);
    }





}
