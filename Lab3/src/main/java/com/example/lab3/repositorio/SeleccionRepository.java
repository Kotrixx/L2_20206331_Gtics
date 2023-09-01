package com.example.lab3.repositorio;
import com.example.lab3.entidad.Seleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
}
