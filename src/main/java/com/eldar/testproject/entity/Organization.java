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
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String physicalAddress;
    @Column(nullable = false)
    String legalAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    Employee head;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Department> departments = new HashSet<>();

}
