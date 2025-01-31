package com.allobank.allobackendtest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Partai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String namaPartai;
    private Integer nomorUrut;
}
