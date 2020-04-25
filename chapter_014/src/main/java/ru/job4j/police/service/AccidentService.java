package ru.job4j.police.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.police.repository.AccidentDao;
import ru.job4j.police.model.Accident;
import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentDao db;

    public List<Accident> findAll() {
        return (List<Accident>) db.findAll();
    }
}
