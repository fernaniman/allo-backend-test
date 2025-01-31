package com.allobank.allobackendtest.Controller;

import com.allobank.allobackendtest.Repository.CalegRepo;
import com.allobank.allobackendtest.Repository.DapilRepo;
import com.allobank.allobackendtest.Repository.PartaiRepo;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private CalegRepo calegRepo;

    @Autowired
    private DapilRepo dapilRepo;

    @Autowired
    private PartaiRepo partaiRepo;

    @GetMapping("/get-all")
    public List<Caleg> getAll() {
        return calegRepo.findAll();
    }

    // mohon maaf apabila konsep filtering dan sorting tidak sesuai dan kurang rapih karena keterbatan waktu dan task pekerjaan yang harus dilakukan di perushaan saat ini
    @GetMapping("/paging")
    public List<Caleg> getPaging(
            @RequestParam(required = false) String namaDapil,
            @RequestParam(required = false) String namaPartai,
            @RequestParam String sorting
    ) {
        switch (sorting) {
            case "asc" :
                if(namaDapil != null && !namaDapil.isEmpty() && namaPartai != null && !namaPartai.isEmpty() ) {
                    return calegRepo.findByDapilNamaDapilIgnoreCaseContainingAndPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutAsc(namaDapil, namaPartai);
                }
                else if(namaDapil != null && !namaDapil.isEmpty()) {
                    return calegRepo.findByDapilNamaDapilIgnoreCaseContainingOrderByNomorUrutAsc(namaDapil);
                } else if(namaPartai != null && !namaPartai.isEmpty()) {
                    return calegRepo.findByPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutAsc(namaPartai);
                }

            case "desc" :
                if(namaDapil != null && !namaDapil.isEmpty() && namaPartai != null && !namaPartai.isEmpty() ) {
                    return calegRepo.findByDapilNamaDapilIgnoreCaseContainingAndPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutDesc(namaDapil, namaPartai);
                }
                else if(namaDapil != null && !namaDapil.isEmpty()) {
                    return calegRepo.findByDapilNamaDapilIgnoreCaseContainingOrderByNomorUrutDesc(namaDapil);
                } else if(namaPartai != null && !namaPartai.isEmpty()) {
                    return calegRepo.findByPartaiNamaPartaiIgnoreCaseContainingOrderByNomorUrutDesc(namaPartai);
                }
        }
        return calegRepo.findAll();

    }

    @PostMapping("/save-caleg")
    public Caleg saveCaleg(@RequestBody Caleg caleg) {
        return calegRepo.save(caleg);
    }

    @PostMapping("/save-dapil")
    public Dapil saveDapil(@RequestBody Dapil dapil) {
        return dapilRepo.save(dapil);
    }

    @PostMapping("/save-partai")
    public Partai savePartai(@RequestBody Partai partai) {
        return partaiRepo.save(partai);
    }

}
