package com.procedure.procedure.dao;

import com.procedure.procedure.model.*;
import org.hibernate.engine.internal.ParameterBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Usuario> getUsuarios() {
        String querry = "FROM Usuario";
        return entityManager.createQuery(querry).getResultList();
    }

    @Override
    public List<Jugador> getJugador() {
        String querry = "FROM Jugador";
        return entityManager.createQuery(querry).getResultList();
    }

    @Override
    public List<Ocupacion> getOcupacion() {
        String querry = "FROM Ocupacion";
        return entityManager.createQuery(querry).getResultList();
    }

    @Override
    public List<Herramienta> getHerramienta() {
        String querry = "FROM Herramienta";
        return entityManager.createQuery(querry).getResultList();
    }

    @Override
    public void RegisterUser(UsuarioReal usuarioReal) {
        String sql = "CALL AGREGAR_CUENTA(:NOMBRE1, :NOMBRE2, :APELLIDO_P, :APELLIDO_M, :NOMBRE_JUGADOR, :CORREO_E, :DIA, :MES, :ANIO, :HERRAMIENTA, :USUARIO_OCUPACION, :PASS)";

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("NOMBRE1", usuarioReal.getName().toString());
        params.addValue("NOMBRE2", usuarioReal.getMiddlename().toString());
        params.addValue("APELLIDO_P", usuarioReal.getLastname().toString());
        params.addValue("APELLIDO_M", usuarioReal.getSecondlastname().toString());
        params.addValue("NOMBRE_JUGADOR", usuarioReal.getJugador().toString());
        params.addValue("CORREO_E", usuarioReal.getEmail().toString());
        params.addValue("DIA", usuarioReal.getDia());
        params.addValue("MES", usuarioReal.getMes());
        params.addValue("ANIO", usuarioReal.getAnio());
        params.addValue("HERRAMIENTA", usuarioReal.getHerramienta());
        params.addValue("USUARIO_OCUPACION", usuarioReal.getOcupacion());
        params.addValue("PASS", usuarioReal.getPassword());

        namedParameterJdbcTemplate.update(sql,params);

    }


}
