package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.exception.ResourceAlreadyExistsException;
import com.example.department.exception.ResourceNotFoundException;
import com.example.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        if (department.getDepartmentId() != null &&
                departmentRepository.existsById(department.getDepartmentId())) {
            throw new ResourceAlreadyExistsException(department.getDepartmentId());
        }
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
