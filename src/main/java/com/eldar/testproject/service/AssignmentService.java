package com.eldar.testproject.service;

import com.eldar.testproject.entity.Assignment;
import com.eldar.testproject.exeption.NotFoundRequestException;
import com.eldar.testproject.repository.AssignmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment getAssignment(Long id){
        return assignmentRepository.findById(id)
                .orElseThrow(()->
                        new NotFoundRequestException(
                                String.format(("Поручение не найдено"))
                        ));
    }
}
