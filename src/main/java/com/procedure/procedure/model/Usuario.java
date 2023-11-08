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
@Table(name = "tbl_usuario")
@ToString @EqualsAndHashCode
public class Usuario {
    @Id
    @Getter @Setter @Column(name = "id_usuario")
    private String id_usuario;

    @Getter @Setter @Column(name = "u_nombre_1")
    private String u_nombre_1;

    @Getter @Setter @Column(name = "u_nombre_2")
    private String u_nombre_2;

    @Getter @Setter @Column(name = "u_apellido_p")
    private String u_apellido_p;

    @Getter @Setter @Column(name = "u_apellido_m")
    private String u_apellido_m;

    @Getter @Setter @Column(name = "u_correo_e")
    private String u_correo_e ;

    @Getter @Setter @Column(name = "u_nacimiento")
    private String u_nacimiento;

    @Getter @Setter @Column(name = "u_fk_ocupacion")
    private  Long u_fk_ocupacion;

    @Getter @Setter @Column(name = "u_fk_uso_h")
    private  Long u_fk_uso_h ;

    @Getter @Setter @Column(name = "u_fk_jugador")
    private  String u_fk_jugador;

}
