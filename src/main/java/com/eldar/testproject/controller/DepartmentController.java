package com.eldar.testproject.controller;

import com.eldar.testproject.entity.Department;
import com.eldar.testproject.service.DepartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

}
