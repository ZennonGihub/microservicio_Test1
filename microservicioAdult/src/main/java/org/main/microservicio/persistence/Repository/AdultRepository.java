package org.main.microservicio.persistence.Repository;

import org.springframework.data.repository.ListCrudRepository;
import org.main.microservicio.persistence.Entitys.AdultEntity;

public interface AdultRepository extends ListCrudRepository<AdultEntity, Long> {
}
