package com.torneo.model;

public class Jugador {
    private Integer id;
    private String nombre;
    private String nickname;
    private String email;
    private String videojuego;

    public Jugador() {}

    public Jugador(Integer id, String nombre, String nickname, String email, String videojuego) {
        this.id = id;
        this.nombre = nombre;
        this.nickname = nickname;
        this.email = email;
        this.videojuego = videojuego;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getVideojuego() { return videojuego; }
    public void setVideojuego(String videojuego) { this.videojuego = videojuego; }
}