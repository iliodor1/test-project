package com.eldar.testproject.service;

import com.eldar.testproject.entity.Department;
import com.eldar.testproject.exeption.BadRequestException;
import com.eldar.testproject.exeption.NotFoundRequestException;
import com.eldar.testproject.repository.DepartmentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DepartmentService {
    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartment(Long id){
        return departmentRepository.findDepartmentById(id)
                .orElseThrow(() ->
                        new NotFoundRequestException(
                                String.format("Подразделение с id %s не найдено", id)
                        )
                );
    }

    public Department createDepartment(Department department){
        try{
            log.info("Saving Department {}", department.getName());
            return departmentRepository.save(department);
        } catch (Exception e) {
            log.error("Error creating department {}", e.getMessage());
            throw new BadRequestException("Что-то пошло не так");
        }
    }

    public Department updateDepartment(Department department){
        Department departmentUpdate = getDepartment(department.getId());
        departmentUpdate.setName(department.getName());
        departmentUpdate.setContactInfo(department.getContactInfo());
        departmentUpdate.setHeadId(department.getHeadId());
        departmentUpdate.setEmployees(department.getEmployees());

        return departmentRepository.save(departmentUpdate);
    }

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id){
        Department department = getDepartment(id);

        departmentRepository.delete(department);
    }
}
