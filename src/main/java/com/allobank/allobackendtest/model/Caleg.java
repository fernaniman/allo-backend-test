package com.allobank.allobackendtest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Caleg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Dapil.class)
    @JoinColumn(name = "dapil_id", referencedColumnName = "id")
    private Dapil dapil;

    @ManyToOne
    @JoinColumn(name = "partai_id", referencedColumnName = "id")
    private Partai partai;

    private Integer nomorUrut;
    private String nama;

    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;
}
