package dao;

import java.util.List;

import entity.Puesto;



public interface IDaopuesto {

	public List<Puesto> findAll();
	public List<Puesto> SelectPuesto(String nombre);
	public Puesto agregarRegistro(Puesto puesto);
	public Puesto eliminarRegistro(Puesto puesto);
	
}
