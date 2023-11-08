package com.procedure.procedure.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_jugador")
@ToString @EqualsAndHashCode
public class Jugador {

    @Id
    @Getter @Setter @Column(name = "id_jugador")
    private String id_jugador;

    @Getter @Setter @Column(name = "j_nombre")
    private String j_nombre;

}
