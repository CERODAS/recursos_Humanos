package com.example.dao;

import java.util.List;

import com.example.entity.Puesto;

public interface IDaoPuesto {
	public List<Puesto> findAll();
	public List<Puesto> SelectPuesto(String nombre);
	public Puesto agregarRegistro(Puesto puesto);
	public Puesto eliminarRegistro(Puesto puesto);
}
