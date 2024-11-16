package cz.itnetwork.springpojistovna.data.repositories;

import cz.itnetwork.springpojistovna.data.entities.InsuranceEntity;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {
}
