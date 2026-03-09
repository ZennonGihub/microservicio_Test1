package org.main.microservicio.service;


import org.main.microservicio.persistence.Entitys.AdultEntity;
import org.main.microservicio.persistence.Repository.AdultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdultService {
    private final AdultRepository adultRepository;

    @Autowired
    public AdultService(AdultRepository adultRepository) {
        this.adultRepository = adultRepository;
    }

    public List<AdultEntity> getList() {
        return this.adultRepository.findAll();
    }
    public AdultEntity getOne(Long id) {
        return this.adultRepository.findById(id).orElse(null);
    }

    public Boolean exist(Long id) {
        return this.adultRepository.existsById(id);
    }

    public AdultEntity save(AdultEntity entity) {
         return this.adultRepository.save(entity);
    }

    public void delete(Long id) {
        this.adultRepository.deleteById(id);
    }

}
