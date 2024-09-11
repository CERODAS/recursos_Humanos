package com.example.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

public class Puesto {
	@Data
	@Entity
	@Table(name = "puesto")
	public class Bitacora {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_puesto")
		public int id_puesto;
		public String nombre;
		public Date fecha_creacion;
		public String empleado_creacion;
		public Date fecha_modificacion;
		public String empleado_modifiacion;
	}
}

