package com.hr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
}
