package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IDaoPersona;
import com.example.entity.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
@Transactional
public class DaoPersona implements IDaoPersona{
	@PersistenceContext
	public EntityManager em;

	@Transactional(readOnly=true) 
	@Override
	public List<Persona> listar() {
		try {
			List<Persona> listaPersona = em.createQuery("FROM Persona p WHERE p.estado = true", Persona.class).getResultList();
		return listaPersona;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Persona> ObtenerPorNombre(String nombre, String apellido) {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
	        Root<Persona> root = criteria.from(Persona.class);
	        
	        Predicate accionCondition = builder.and(
	        		builder.equal(root.get("nombre"), nombre),
	        		builder.equal(root.get("apellido"), apellido)
	        );

	        criteria.where(builder.or(accionCondition));
	        
	        return em.createQuery(criteria).getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Persona agregarPersona(Persona persna) {
		try {
			em.persist(persna);
			return persna;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Persona actualizarPersona(Persona prsna) {
		try {
			em.merge(prsna);
			return prsna;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Persona eliminarPersona(int id) {
		try {
			Persona prsna = em.find(Persona.class, id);
			
			if(prsna != null) {
				prsna.setEstado(false);
				em.merge(prsna);
			}
			return prsna;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}