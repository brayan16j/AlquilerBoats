package com.example.usa.boats.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@Setter
@Getter
public class AdminModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT
    private Integer idAdmin;

    private String email;
    private String password;
    private String name;



}
