package ru.job4j.police.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.job4j.police.model.Accident;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentRowMapper implements RowMapper<Accident> {
    @Override
    public Accident mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Accident accident = new Accident();
        accident.setId(resultSet.getInt("id"));
        accident.setName(resultSet.getString("name"));
        accident.setDescription(resultSet.getString("description"));
        accident.setAddress(resultSet.getString("address"));
        return accident;
    }
}
