package com.example.lab3.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador")
@Getter
@Setter
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idJugador;


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)

    private Integer edad;

    @Column(nullable = false)
    private String posicion;

    @Column(nullable = false)
    private String club;

    @Column(name = "sn_idSeleccion",nullable = false)
    private Integer idSeleccion;
}
