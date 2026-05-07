package com.torneo.dao;

import com.torneo.model.Jugador;
import java.sql.SQLException;
import java.util.List;

public interface IJugadorDAO {
    List<Jugador> findAll() throws SQLException;
    Jugador findById(int id) throws SQLException;
    void save(Jugador jugador) throws SQLException;
    void update(Jugador jugador) throws SQLException;
    void delete(int id) throws SQLException;
}