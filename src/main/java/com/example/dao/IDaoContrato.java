package com.example.dao;

import java.util.List;

import com.example.entity.Contrato;


public interface IDaoContrato {
	public List<Contrato> findAll();
	public Contrato findById(int id);
	public Contrato save(Contrato contrato);
	public Contrato update(Contrato contrato);

}
