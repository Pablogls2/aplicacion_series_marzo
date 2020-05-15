package com.example.proyecto_final.controlador;


import com.example.proyecto_final.dao.UsuariosDao;
import com.example.proyecto_final.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/")
public class Controlador {

    @Autowired
    private UsuariosDao ud;



    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {

        // Se conecta y busca los usuarios
        List<Usuario> l = ud.findAll();
        // Devolvemos la ista de usuarios
        return ResponseEntity.ok(l);
    }

    /**
     * Metodo para insertar un usuario nuevo
     *
     * @param user
     * @return Usuario
     */
    @RequestMapping(value = "registro", method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
        //Se crea un usuario nuevo a partir del que ha llegado
        Usuario p = ud.save(user);

        //devolvemos el nuevo usuario
        return ResponseEntity.ok(p);
    }

    /**
     * Método para borrar un usuario
     * @param id
     * @return Usuario
     */
    @RequestMapping(value = "borrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("id") long id) {
        // Buscamos el usuario por id
        Optional<Usuario> op = ud.findById(id);
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            // Le pasamos los datos
            Usuario p = op.get();
            ud.deleteById(id);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }





}
