package org.main.microservicio.service;


import org.main.microservicio.persistence.Entitys.ChildEntity;
import org.main.microservicio.persistence.Repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public List<ChildEntity> getList() {
        System.out.println(this.childRepository.findAll());
        return this.childRepository.findAll();
    }
    public ChildEntity getOne(Long id) {
        return this.childRepository.findById(id).orElse(null);
    }

    public Boolean exist(Long id) {
        return this.childRepository.existsById(id);
    }

    public ChildEntity save(ChildEntity entity) {
        System.out.println("Esta es la entity" + entity);
         return this.childRepository.save(entity);
    }

    public void delete(Long id) {
        this.childRepository.deleteById(id);
    }

}
