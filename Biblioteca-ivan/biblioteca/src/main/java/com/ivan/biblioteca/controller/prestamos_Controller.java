package com.ivan.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.biblioteca.interfacesService.Interfaz_prestamoService;
import com.ivan.biblioteca.models.Prestamos;







@RequestMapping("/api/v1/prestamos")
@RestController
@CrossOrigin
public class prestamos_Controller {
    
    @Autowired
	private Interfaz_prestamoService prestamoService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(
			@ModelAttribute("prestamo")Prestamos prestamo
			){
		prestamoService.save(prestamo);
		return new ResponseEntity<>(prestamo,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var listaPrestamo=prestamoService.findAll();
		return new ResponseEntity<>(listaPrestamo,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable("id") String id){
		var prestamo=prestamoService.findOne(id);
		return new ResponseEntity<>(prestamo,HttpStatus.OK);
	}
	


	@PostMapping("/editarPrestamo/{id}")
	public String actualizarPrestamo(@PathVariable("id") String id, @ModelAttribute("prestamo") Prestamos prestamoUpdate) {
	   
	    return "redirect:/listaPrestamos";  
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		prestamoService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("prestamo") Prestamos prestamoUpdate){
		var prestamo= prestamoService.findOne(id).get();
		if (prestamo != null) {
			prestamo.setFechadelPrestamo(prestamoUpdate.getFechadelPrestamo());
			prestamo.setFechaDevolucion(prestamoUpdate.getFechaDevolucion());
			prestamo.setUsuarios(prestamoUpdate.getUsuarios());
			prestamo.setLibro(prestamoUpdate.getLibro());
			prestamo.setEstado(prestamoUpdate.getEstado());
			
			prestamoService.save(prestamo);
			return new ResponseEntity<>("Guardado",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error prestamo no encontrado",HttpStatus.BAD_REQUEST);
		}
		
	}


}
