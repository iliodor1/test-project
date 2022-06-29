package com.eldar.testproject.repository;

import com.eldar.testproject.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    @Override
    Optional<Assignment> findById(Long aLong);

}
