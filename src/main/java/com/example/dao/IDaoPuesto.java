package com.example.dao;

import java.util.List;

import com.example.entity.Puesto;

public interface IDaoPuesto {
	public List<Puesto> findAll();
    public Puesto findById(int id);

}
