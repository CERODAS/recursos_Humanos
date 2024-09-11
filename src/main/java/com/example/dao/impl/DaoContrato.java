package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IDaoContrato;
import com.example.entity.Contrato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class DaoContrato implements IDaoContrato{
	@PersistenceContext
	private EntityManager em;
	
	 @Transactional(readOnly = true)
	    @Override
	    public List<Contrato> findAll() {
	        try {
	            List<Contrato> listaContratos = em.createQuery("FROM Contrato", Contrato.class).getResultList();
	            return listaContratos;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Transactional(readOnly = true)
	    @Override
	    public Contrato findById(int id) {
	        try {
	        	Contrato contrato = em.find(Contrato.class, id);
	            return contrato;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public Contrato save(Contrato contrato) {
	        try {
	            em.persist(contrato);
	            return contrato;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public Contrato update(Contrato contrato) {
	        try {
	            em.merge(contrato);
	            return contrato;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
		

}
