package com.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstapp.model.Department;

/* JpaRepository takes two parameters, one is the model and the primary key datatype
 * @Repository annotation is going to implement JPA which will convert regular sql queries into methods and classes.
 * Here we are mentioning the name of the class model and that attribute which is our primary key*/
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
