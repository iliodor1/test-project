package com.eldar.testproject.controller;

import com.eldar.testproject.entity.Organization;
import com.eldar.testproject.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        return organizationService.getOrganization(id);
    }

    @GetMapping
    public List<Organization> getOrganizations() {
        return organizationService.getOrganizations();
    }

    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @PutMapping
    public Organization updateOrganization(@RequestBody Organization organization) {
        return organizationService.updateOrganization(organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }

}
