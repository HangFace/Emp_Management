package com.dhruv.emp_management.service;

import com.dhruv.emp_management.entity.Employee;
import com.dhruv.emp_management.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public void addEmp(Employee employee) {
        empRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return empRepository.findAll();
    }

    public Employee edit(int id) {
        Optional<Employee> optional = empRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public void delete(int id){
        empRepository.deleteById(id);
    }
}
