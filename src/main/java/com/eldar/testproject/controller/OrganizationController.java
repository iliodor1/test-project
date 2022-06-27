package com.eldar.testproject.controller;

import com.eldar.testproject.entity.Employee;
import com.eldar.testproject.entity.Organization;
import com.eldar.testproject.service.EmployeeService;
import com.eldar.testproject.service.OrganizationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrganizationController {
    OrganizationService organizationService;

    @GetMapping("/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        return organizationService.getOrganization(id);
    }

    @GetMapping
    public List<Organization> getOrganizations() {
        return organizationService.getOrganizations();
    }

    @PostMapping
    public Organization createOrganization(Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @PutMapping
    public Organization updateOrganization(Organization organization) {
        return organizationService.updateOrganization(organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }

}
