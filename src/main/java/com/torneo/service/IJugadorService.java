package com.torneo.service;

import com.torneo.model.Jugador;
import java.sql.SQLException;
import java.util.List;

public interface IJugadorService {
    List<Jugador> obtenerTodos() throws SQLException;
    Jugador obtenerPorId(int id) throws SQLException;
    void crear(Jugador jugador) throws SQLException;
    void actualizar(Jugador jugador) throws SQLException;
    void eliminar(int id) throws SQLException;
}