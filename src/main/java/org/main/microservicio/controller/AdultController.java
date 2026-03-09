package org.main.microservicio.controller;

import org.main.microservicio.persistence.Entitys.AdultEntity;
import org.main.microservicio.persistence.Entitys.ChildEntity;
import org.main.microservicio.service.AdultService;
import org.main.microservicio.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/adults")
public class AdultController {
    private final AdultService adultService;

    @Autowired
    public AdultController(AdultService adultService) {
        this.adultService = adultService;
    }

    @GetMapping
    public ResponseEntity<List<AdultEntity>> getList() {
        return ResponseEntity.ok(this.adultService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdultEntity> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.adultService.getOne(id));
    }

    @PostMapping("/save")
    public void save(@RequestBody AdultEntity entity) {
        this.adultService.save(entity);
    }

    @PutMapping("update")
    public ResponseEntity<AdultEntity> update(@RequestBody AdultEntity entity) {
        if(entity.getId() != null && this.adultService.exist(entity.getId())) {
            return ResponseEntity.ok(this.adultService.save(entity));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(Long id) {
        if(this.adultService.exist(id)) {
            this.adultService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
