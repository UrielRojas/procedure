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
@Table(name = "tbl_ocupacion")
@ToString @EqualsAndHashCode
public class Ocupacion {

    @Id
    @Getter @Setter @Column(name = "id_ocupacion")
    private Long id_ocupacion;

    @Getter @Setter @Column(name = "ocupacion ")
    private String ocupacion ;
}
