package com.procedure.procedure.controllers;

import com.procedure.procedure.dao.UsuarioDao;
import com.procedure.procedure.model.*;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ControladorUsuario {
    @Autowired
    private UsuarioDao usuarioDao;



    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {



        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/jugador", method = RequestMethod.GET)
    public List<Jugador> getJugador(){
        return usuarioDao.getJugador();

    }

    @RequestMapping(value = "api/ocupacion", method = RequestMethod.GET)
    public List<Ocupacion> getOcupacion(){
        return usuarioDao.getOcupacion();

    }

    @RequestMapping(value = "api/herramienta", method = RequestMethod.GET)
    public List<Herramienta> getHerramienta(){
        return usuarioDao.getHerramienta();

    }

    @PostMapping("api/usuarioReal")
    public void RegisterUser(@RequestBody UsuarioReal usuarioReal){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1, usuarioReal.getPassword());
        usuarioReal.setPassword(hash);

        usuarioDao.RegisterUser(usuarioReal);
    }

}

