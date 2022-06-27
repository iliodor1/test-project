package com.eldar.testproject.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    String firstName;
    String patronymic;
    @Column(nullable = false)
    String position;

}
