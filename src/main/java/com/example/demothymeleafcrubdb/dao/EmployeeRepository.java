package com.example.demothymeleafcrubdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demothymeleafcrubdb.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
