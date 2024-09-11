package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IDaoEmpleado;
import com.example.entity.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class DaoEmpleado implements IDaoEmpleado {
	@PersistenceContext
	private EntityManager em;

	    @Transactional(readOnly = true)
	    @Override
	    public List<Empleado> findAll() {
	        try {
	            List<Empleado> listaEmpleados = em.createQuery("FROM Empleado", Empleado.class).getResultList();
	            return listaEmpleados;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Transactional(readOnly = true)
	    @Override
	    public Empleado findById(int id) {
	        try {
	            Empleado empleado = em.find(Empleado.class, id);
	            return empleado;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public Empleado save(Empleado empleado) {
	        try {
	            em.persist(empleado);
	            return empleado;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public Empleado update(Empleado empleado) {
	        try {
	            em.merge(empleado);
	            return empleado;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
