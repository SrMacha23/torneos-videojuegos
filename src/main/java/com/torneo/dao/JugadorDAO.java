package com.torneo.dao;

import com.torneo.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JugadorDAO implements IJugadorDAO {

    @Autowired
    private DataSource dataSource;

    public List<Jugador> findAll() throws SQLException {
        List<Jugador> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, nickname, email, videojuego FROM jugadores";
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Jugador(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("nickname"),
                    rs.getString("email"),
                    rs.getString("videojuego")
                ));
            }
        }
        return lista;
    }

public Jugador findById(int id) throws SQLException {
    String sql = "SELECT id, nombre, nickname, email, videojuego FROM jugadores WHERE id = ?";
    try (Connection con = dataSource.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new Jugador(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("nickname"),
                    rs.getString("email"),
                    rs.getString("videojuego")
                );
            }
        }
    }
    return null;
}



    public void save(Jugador j) throws SQLException {
        String sql = "INSERT INTO jugadores (nombre, nickname, email, videojuego) VALUES (?, ?, ?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getNickname());
            ps.setString(3, j.getEmail());
            ps.setString(4, j.getVideojuego());
            ps.executeUpdate();
        }
    }

    public void update(Jugador j) throws SQLException {
        String sql = "UPDATE jugadores SET nombre=?, nickname=?, email=?, videojuego=? WHERE id=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getNickname());
            ps.setString(3, j.getEmail());
            ps.setString(4, j.getVideojuego());
            ps.setInt(5, j.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM jugadores WHERE id = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}