package com.allobank.allobackendtest.Repository;

import com.allobank.allobackendtest.model.Caleg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalegRepo extends JpaRepository<Caleg, Integer> {

    // asc
    List<Caleg> findByDapilNamaDapilIgnoreCaseContainingAndPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutAsc(String namaDapil, String namaPartai);
    List<Caleg> findByDapilNamaDapilIgnoreCaseContainingOrderByNomorUrutAsc(String namaDapil);
    List<Caleg> findByPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutAsc(String namaPartai);

    // asc
    List<Caleg> findByDapilNamaDapilIgnoreCaseContainingAndPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutDesc(String namaDapil, String namaPartai);
    List<Caleg> findByDapilNamaDapilIgnoreCaseContainingOrderByNomorUrutDesc(String namaDapil);
    List<Caleg> findByPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutDesc(String namaPartai);

}
