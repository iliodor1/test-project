package com.eldar.testproject.service;

import com.eldar.testproject.entity.Organization;
import com.eldar.testproject.exeption.BadRequestException;
import com.eldar.testproject.exeption.NotFoundRequestException;
import com.eldar.testproject.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization getOrganization(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundRequestException(
                                String.format("Организация с id %s не найдена", id)
                        )
                );
    }

    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization createOrganization(Organization organization) {
        try {
            log.info("Saving Organization {}", organization.getName());
            return organizationRepository.save(organization);
        } catch (Exception e) {
            log.error("Error creating organization {}", e.getMessage());
            throw new BadRequestException("Что-то пошло не так");
        }
    }

    public Organization updateOrganization(Organization organization) {
        Organization organizationUpdate = getOrganization(organization.getId());
        organization.setName(organizationUpdate.getName());
        organization.setPhysicalAddress(organizationUpdate.getPhysicalAddress());
        organization.setLegalAddress(organizationUpdate.getLegalAddress());
        organization.setHead(organizationUpdate.getHead());
        organization.setDepartments(organizationUpdate.getDepartments());

        return organizationRepository.save(organizationUpdate);
    }

    public void deleteOrganization(Long id) {
        Organization organization = getOrganization(id);

        organizationRepository.delete(organization);
    }

}
