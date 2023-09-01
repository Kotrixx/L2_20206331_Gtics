package com.example.lab3.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seleccion")
@Getter
@Setter
public class Seleccion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idSeleccion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)

    private String tecnico;

    @Column(name = "estadios_idEstadios",nullable = false)
    private Integer idEstadios;
}
