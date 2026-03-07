package org.main.microservicio.persistence.Repository;

import org.springframework.data.repository.ListCrudRepository;
import org.main.microservicio.persistence.Entitys.ChildEntity;

public interface ChildRepository extends ListCrudRepository<ChildEntity, Long> {
}
