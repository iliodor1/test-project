package com.eldar.testproject.service;

import com.eldar.testproject.entity.Employee;
import com.eldar.testproject.exeption.BadRequestException;
import com.eldar.testproject.exeption.NotFoundRequestException;
import com.eldar.testproject.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Long id) throws NotFoundRequestException {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundRequestException(
                                String.format("Сотрудник c id %s не найден", id)
                        )
                );
    }

    public Employee createEmployee(Employee employee) {
        try {
            log.info("Saving Employee {} {}", employee.getLastName(), employee.getFirstName());
            return employeeRepository.save(employee);
        } catch (Exception e) {
            log.error("Error creating employee {}", e.getMessage());
            throw new BadRequestException("Что-то пошло не так");
        }
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        Employee employeeUpdate = getEmployee(employee.getId());
        employeeUpdate.setFirstName(employee.getFirstName());
        employeeUpdate.setLastName(employee.getLastName());
        employeeUpdate.setPatronymic(employee.getPatronymic());
        employeeUpdate.setPosition(employee.getPosition());

        return employeeRepository.save(employeeUpdate);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployee(id);

        employeeRepository.delete(employee);
    }

}
