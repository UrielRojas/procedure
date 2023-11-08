package com.procedure.procedure.dao;

import com.procedure.procedure.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UsuarioDao{
    List<Usuario> getUsuarios();

    List<Jugador> getJugador();

    List<Ocupacion> getOcupacion();

    List<Herramienta> getHerramienta();


    void RegisterUser(UsuarioReal usuarioReal);
}
