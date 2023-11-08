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
@Table(name = "tbl_uso_herramienta")
@ToString @EqualsAndHashCode
public class Herramienta {
    @Id
    @Getter @Setter @Column (name = "id_uso_h ")
    private Long id_uso_h;

    @Getter @Setter @Column (name = "motivo  ")
    private String motivo ;

}
