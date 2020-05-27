package com.example.proyecto_final.modelos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Estado")
@Data @Getter  @Setter
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private long codigo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula  pelicula;


    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;


    //0 pelicula , 1 serie
    @Column( nullable = false, length = 1)
    private int tipo;
    @Column( nullable = false, length = 50)
    private String estado;
}
