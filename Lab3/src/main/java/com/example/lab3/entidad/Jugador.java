package com.example.lab3.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador")
@Getter
@Setter
public class Jugador {

    @Id
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
