package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.IDaoUsuario;
import com.example.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DaoUsuario implements IDaoUsuario {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<Usuario> listar() {
		TypedQuery<Usuario> query = em.createQuery("from Usuario", Usuario.class);

		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Usuario obtenerPorNombre(String nombreUsuario) {
		TypedQuery<Usuario> query = em.createQuery("from Usuario where nombreUsuario = :nombreUsuario", Usuario.class);

		query.setParameter("nombreUsuario", nombreUsuario);

		try {
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	@Transactional
	public Usuario crear(Usuario usuario) {
		try {
			em.persist(usuario);
			return usuario;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usuario) {
		try {
			em.merge(usuario);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
