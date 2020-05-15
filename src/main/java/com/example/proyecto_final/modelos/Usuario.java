package com.example.proyecto_final.modelos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Data @Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private long codigo;


    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "rol", nullable = false)
    private String rol;

   @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "nickname", nullable = false, length = 50, unique = true)
    private String nickname;

    @Column(name = "password", nullable = false, length = 50, unique = true)
    private String password;

    @Column(name = "foto_perfil")
    private String foto_perfil;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String apellidos, String rol, String email, String nickname, String password, String foto_perfil) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rol = rol;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.foto_perfil = foto_perfil;
    }

}
