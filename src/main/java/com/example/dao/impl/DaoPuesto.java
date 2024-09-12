package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IDaoPuesto;
import com.example.entity.Puesto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoPuesto implements IDaoPuesto{
	@PersistenceContext
	private EntityManager em;

	    @Transactional(readOnly = true)
	    @Override
	    public List<Puesto> findAll() {
	        try {
	            List<Puesto> listaPuestos = em.createQuery("FROM Puesto", Puesto.class).getResultList();
	            return listaPuestos;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Transactional(readOnly = true)
	    @Override
	    public Puesto findById(int id) {
	        try {
	            Puesto puesto = em.find(Puesto.class, id);
	            return puesto;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
