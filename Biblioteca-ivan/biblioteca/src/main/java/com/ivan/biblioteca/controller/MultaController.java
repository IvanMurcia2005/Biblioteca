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

import com.ivan.biblioteca.interfacesService.Interfaz_multaService;
import com.ivan.biblioteca.models.Multa;




@RequestMapping("/api/v1/multas")
@RestController
@CrossOrigin
public class MultaController {
 
       @Autowired
	private Interfaz_multaService multasService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(
			@ModelAttribute("multas")Multa multas
			){
		multasService.save(multas);
		return new ResponseEntity<>(multas,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var listaMultas=multasService.findAll();
		return new ResponseEntity<>(listaMultas,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable("id") String id){
		var multas=multasService.findOne(id);
		return new ResponseEntity<>(multas,HttpStatus.OK);
	}
	


	@PostMapping("/editarMulta/{id}")
	public String actualizarMulta(@PathVariable("id") String id, @ModelAttribute("multas") Multa multasUpdate) {
	    
	    return "redirect:/listaMultas"; 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		multasService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("multas") Multa multasUpdate){
		var multas= multasService.findOne(id).get();
		if (multas != null) {
			multas.setUsuario(multasUpdate.getUsuario());
			multas.setPrestamo(multasUpdate.getPrestamo());
			multas.setValor_de_multa(multasUpdate.getValor_de_multa());
			multas.setFecha_de_multa(multasUpdate.getFecha_de_multa());
			multas.setEstado(multasUpdate.getEstado());
			
			multasService.save(multas);
			return new ResponseEntity<>("Guardado",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error multa no encontrada",HttpStatus.BAD_REQUEST);
		}
		
	}



}
