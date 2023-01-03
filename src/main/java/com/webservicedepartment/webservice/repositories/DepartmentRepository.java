package com.webservicedepartment.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicedepartment.webservice.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>  {

}
