package com.eldar.testproject.service;

import com.eldar.testproject.entity.Organization;
import com.eldar.testproject.exeption.NotFoundRequestException;
import com.eldar.testproject.repository.OrganizationRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrganizationService {
    OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization getOrganization(Long id) {
        return organizationRepository.findOrganizationById(id)
                .orElseThrow(() ->
                        new NotFoundRequestException(
                                String.format("Организация с id %s не найдена", id)
                        )
                );
    }

    public List<Organization> getOrganizations() {
        throw new UnsupportedOperationException("not implemented");
    }

    public Organization createOrganization(Organization organization) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Organization updateOrganization(Organization organization) {
        throw new UnsupportedOperationException("not implemented");
    }

    public void deleteOrganization(Long id) {
        throw new UnsupportedOperationException("not implemented");
    }

}
