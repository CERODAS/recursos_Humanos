package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IDaoPuesto;
import com.example.entity.Puesto;

@RestController
@RequestMapping(value = ("/rrhh"))
@CrossOrigin(origins = "http://localhost:3000")
public class PuestoControllers {
	@Autowired
    private IDaoPuesto daoPuesto;

    @GetMapping(value = "/puestos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Puesto> getEmpleados() {
		return daoPuesto.findAll();
	}

	@GetMapping(value = "/puestos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Puesto> getPuestoById(@PathVariable int id) {
		Puesto puesto = daoPuesto.findById(id);
		if (puesto != null) {
			return ResponseEntity.ok(puesto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
