package com.eldar.testproject.repository;

import com.eldar.testproject.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Override
    Optional<Organization> findById(Long id);

}
