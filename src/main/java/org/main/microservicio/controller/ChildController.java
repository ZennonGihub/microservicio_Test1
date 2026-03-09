package org.main.microservicio.controller;


import org.main.microservicio.persistence.Entitys.ChildEntity;
import org.main.microservicio.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/childs")
public class ChildController {
    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping
    public ResponseEntity<List<ChildEntity>> getList() {
        return ResponseEntity.ok(this.childService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildEntity> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.childService.getOne(id));
    }

    @PostMapping("/save")
    public void save(@RequestBody ChildEntity entity) {
        this.childService.save(entity);
    }

    @PutMapping("/update")
    public ResponseEntity<ChildEntity> update(@RequestBody ChildEntity entity) {
        System.out.println("Llego a la peticion");
        if(entity.getId() != null && this.childService.exist(entity.getId())) {
            return ResponseEntity.ok(this.childService.save(entity));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(this.childService.exist(id)) {
            this.childService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
