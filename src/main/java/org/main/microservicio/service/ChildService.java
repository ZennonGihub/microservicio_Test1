package org.main.microservicio.service;


import org.main.microservicio.persistence.Entitys.ChildEntity;
import org.main.microservicio.persistence.Repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {
    private final ChildRepository childRepository;


    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public ResponseEntity<List<ChildEntity>> getList(ChildEntity entity) {
        return ResponseEntity.ok(this.childRepository.findAll());
    }
    public ResponseEntity<ChildEntity> getOne(Long id) {
        return ResponseEntity.ok(this.childRepository.findById(id).orElse(null));
    }

    public Boolean exist(Long id) {
        return this.childRepository.existsById(id);
    }

    public ResponseEntity<ChildEntity> save(ChildEntity entity) {
         return ResponseEntity.ok(this.childRepository.save(entity));
    }

    public void delete(Long id) {
        this.childRepository.deleteById(id);
    }

}
