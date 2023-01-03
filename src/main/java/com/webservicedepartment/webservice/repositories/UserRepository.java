package com.webservicedepartment.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicedepartment.webservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
