package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IDaoContrato;
import com.example.entity.Contrato;


@RestController
@RequestMapping(value = ("/rrhh"))
@CrossOrigin(origins = "http://localhost:3000")
public class ContratoController {
	 @Autowired
	    private IDaoContrato daoContratos;

	    @GetMapping(value = "/contratos", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Contrato> getContratos() {
			return daoContratos.findAll();
		}

		@GetMapping(value = "/contratos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Contrato> getContratoById(@PathVariable int id) {
			Contrato contrato = daoContratos.findById(id);
			if (contrato != null) {
				return ResponseEntity.ok(contrato);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@PostMapping(value = "/contratos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Contrato save(@RequestBody Contrato contrato) {
			return daoContratos.save(contrato);
		}

		@PutMapping(value = "/contratos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Contrato update(@RequestBody Contrato contrato){
			return daoContratos.update(contrato);
		}
	

}
