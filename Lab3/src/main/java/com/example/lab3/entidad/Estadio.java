package com.example.lab3.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadio")
@Getter
@Setter
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,length = 40)
    private Integer idEstadio;

    @Column(nullable = false,length = 40)

    private String nombre;


    @Column(nullable = false,length = 40)
    private String provincia;

    private String club;

}
