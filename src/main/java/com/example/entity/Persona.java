package com.example.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	public String nombre;
	public String apellido;
	public String dpi;
	public String email;
	public String telefono;
	public String direccion;
	public Date fecha_nacimiento;
	public Boolean estado;
	public String usuario_creacion;
	public String usuario_modificacion;
}