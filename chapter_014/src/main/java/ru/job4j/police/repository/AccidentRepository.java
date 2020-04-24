package ru.job4j.police.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.police.model.Accident;
import java.util.List;

@Repository
public class AccidentRepository {
    private final static String SQL_GET_ALL = "SELECT * FROM accident";
    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Accident> findAll() {
        return template.query(SQL_GET_ALL, new AccidentRowMapper());
    }
}
