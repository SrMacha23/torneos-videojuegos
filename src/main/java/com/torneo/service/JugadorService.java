package com.torneo.service;

import com.torneo.dao.IJugadorDAO;
import com.torneo.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class JugadorService implements IJugadorService {

    @Autowired
    private IJugadorDAO jugadorDAO;

    public List<Jugador> obtenerTodos() throws SQLException {
        return jugadorDAO.findAll();
    }

    public Jugador obtenerPorId(int id) throws SQLException {
        return jugadorDAO.findById(id);
    }

    public void crear(Jugador jugador) throws SQLException {
        jugadorDAO.save(jugador);
    }

    public void actualizar(Jugador jugador) throws SQLException {
        jugadorDAO.update(jugador);
    }

    public void eliminar(int id) throws SQLException {
        jugadorDAO.delete(id);
    }
}