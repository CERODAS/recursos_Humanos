package com.example.dao;

import java.util.List;

import com.example.entity.Empleado;



public interface IDaoEmpleado {
	 public List<Empleado> findAll();
	    public Empleado findById(int id);
	    public Empleado save(Empleado empleado);
	    public Empleado update(Empleado empleado);
}
