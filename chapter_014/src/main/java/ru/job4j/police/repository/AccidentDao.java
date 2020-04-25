package ru.job4j.police.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.police.model.Accident;

@Repository
public interface AccidentDao extends CrudRepository<Accident, Integer> {
}
