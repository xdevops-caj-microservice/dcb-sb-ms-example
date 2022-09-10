package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/departments")
@Validated
@Slf4j
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("")
    public Department saveDepartment(@RequestBody @Valid Department department) {
        log.info("Call saveDepartment() in DepartmentController...");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable @Min(1) Long id) {
        log.info("Call findDepartmentById() in DepartmentController...");
        return departmentService.findDepartmentById(id);
    }
}
