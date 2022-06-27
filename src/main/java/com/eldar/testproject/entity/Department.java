package com.eldar.testproject.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String contactInfo;
    @Column(nullable = false)
    Long headId;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Employee> employees = new HashSet<>();
}
