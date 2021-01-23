package ru.geekbrains.security.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles", schema = "security")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
