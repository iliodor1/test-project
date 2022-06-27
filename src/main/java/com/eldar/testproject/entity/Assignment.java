package com.eldar.testproject.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String subject;
    @ManyToOne(fetch = FetchType.LAZY)
    Employee author;
    @ManyToOne(fetch = FetchType.LAZY)
    Employee executor;
    LocalDate executionPeriod;
    String control;
    String signExecution;
    String text;

}
