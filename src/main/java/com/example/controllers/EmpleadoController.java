package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IDaoEmpleado;
import com.example.entity.Empleado;


@RestController
@RequestMapping(value = ("/rrhh"))
public class EmpleadoController {
	 @Autowired
	    private IDaoEmpleado daoEmpleados;

	    @GetMapping(value = "/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Empleado> getEmpleados() {
			return daoEmpleados.findAll();
		}

		@GetMapping(value = "/empleados/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
			Empleado empleado = daoEmpleados.findById(id);
			if (empleado != null) {
				return ResponseEntity.ok(empleado);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@PostMapping(value = "/empleados", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Empleado save(@RequestBody Empleado empleado) {
			return daoEmpleados.save(empleado);
		}

		@PutMapping(value = "/empleados", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Empleado update(@RequestBody Empleado empleado){
			return daoEmpleados.update(empleado);
		}
}
