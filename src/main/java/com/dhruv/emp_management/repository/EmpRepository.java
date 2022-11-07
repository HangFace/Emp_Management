package com.dhruv.emp_management.repository;

import com.dhruv.emp_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
