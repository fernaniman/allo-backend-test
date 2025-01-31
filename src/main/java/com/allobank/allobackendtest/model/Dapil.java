package com.allobank.allobackendtest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Dapil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String namaDapil;
    private String provinsi;

//    private List<wilayahDapil> wilayahDapilList;

    private String wilayahDapil;

    private Integer jumlahKursi;
}
