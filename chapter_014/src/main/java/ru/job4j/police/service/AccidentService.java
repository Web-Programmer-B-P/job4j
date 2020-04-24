package ru.job4j.police.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.police.model.Accident;
import ru.job4j.police.repository.AccidentRepository;
import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentRepository db;

    public List<Accident> findAll() {
        return db.findAll();
    }
}
