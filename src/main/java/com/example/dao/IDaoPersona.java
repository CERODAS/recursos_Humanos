package com.example.dao;

import java.util.List;

import com.example.entity.Persona;

public interface IDaoPersona {
	public List<Persona> listar();
	public List<Persona> ObtenerPorNombre(String nombre, String apellido);
	public Persona agregarPersona(Persona persna);
	public Persona actualizarPersona(Persona prsna);
	public Persona eliminarPersona(int id);
}