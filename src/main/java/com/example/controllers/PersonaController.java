package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IDaoPersona;
import com.example.entity.Persona;

@RestController
@RequestMapping(value = "/rrhh")

@CrossOrigin(origins = "http://localhost:3000")
public class PersonaController {
	@Autowired
	public IDaoPersona daoPrsna;
	
	@GetMapping(value = "/persona/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> listarPersona(){
		return daoPrsna.listar();
	}
	
	@GetMapping(value ="/persona/buscarPorNombre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> buscarBitacora(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido) {

        try {
            List<Persona> resultados = daoPrsna.ObtenerPorNombre(nombre, apellido);
            if (resultados.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(resultados, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping(value = "/persona/agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona crearPersona(@RequestBody Persona prsna) {
		return daoPrsna.agregarPersona(prsna);
	}
	
	@PutMapping(value = "/persona/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona actualizrPersona(@RequestBody Persona prsna) {
		return daoPrsna.actualizarPersona(prsna);
	}
	
	@PutMapping(value = "/persoan/eliminmar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Persona eliminarPersona(@PathVariable int id) {
		return daoPrsna.eliminarPersona(id);
	}
}