package com.example.proyecto_final.modelos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Pelicula")
@Data @Getter @Setter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private long codigo;

    @Column( nullable = false, length = 50)
    private String titulo;
    @Column( nullable = false, length = 50)
    private String sinopsis;
    @Column( nullable = false, length = 4)
    private int duracion;
    @Column( nullable = false, length = 50)
    private String fecha;
    @Column( nullable = false, length = 50)
    private String reparto;
    @Column( nullable = false, length = 50)
    private String caratula;
    @Column( nullable = true, length = 50)
    private String trailer;
    @Column( nullable = false, length = 50)
    private int cod_valoracion;
    @Column( nullable = false, length = 50)
    private int cod_comentario;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Estado> estado;


}
