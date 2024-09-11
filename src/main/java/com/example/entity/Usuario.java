package com.example.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	    
	 @Column(name = "empleado_id", nullable = false)
	 private int empleadoId;
	 
	 @Column(name = "nombre_usuario", nullable = false, unique = true)
	 private String nombreUsuario;
	 
	 @Column(name = "clave", nullable = false)
	 private String clave;

	 @Column(name = "rol", nullable = false)
	 private String rol;

	 @Column(name = "status", nullable = false)
	 private boolean status;

	 @Column(name = "fecha_creacion", updatable = false)
	 private Timestamp fechaCreacion;

	 @Column(name = "fecha_modificacion")
	 private Timestamp fechaModificacion;

	 @Column(name = "usuario_creacion")
	 private Integer usuarioCreacion;

	 @Column(name = "usuario_modificacion")
	 private Integer usuarioModificacion;
}
