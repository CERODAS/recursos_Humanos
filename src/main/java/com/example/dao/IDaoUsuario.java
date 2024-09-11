package com.example.dao;

import java.util.List;

import com.example.entity.Usuario;

public interface IDaoUsuario {
    List<Usuario> listar();
    Usuario obtenerPorNombre(String nombreUsuario);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Usuario usuario);
}
