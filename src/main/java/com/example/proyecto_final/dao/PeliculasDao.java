package com.example.proyecto_final.dao;

import com.example.proyecto_final.modelos.Pelicula;
import com.example.proyecto_final.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PeliculasDao  extends JpaRepository<Pelicula, Long> {
}
