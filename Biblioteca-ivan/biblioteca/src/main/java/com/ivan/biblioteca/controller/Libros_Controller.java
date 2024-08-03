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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.biblioteca.interfacesService.Interfaz_LibroService;
import com.ivan.biblioteca.models.Libro;




@RequestMapping("/api/v1/libros/")
@RestController
@CrossOrigin
public class Libros_Controller {


    @Autowired
	private Interfaz_LibroService libroService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(
			@ModelAttribute("libro")Libro libro
			){
		libroService.save(libro);
		return new ResponseEntity<>(libro,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var listaLibro=libroService.findAll();
		return new ResponseEntity<>(listaLibro,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable("id") String id){
		var libro=libroService.findOne(id);
		return new ResponseEntity<>(libro,HttpStatus.OK);
	}
	
	// @GetMapping("/editarLibro/{id}")
	// public String mostrarFormularioDeEditarLibro(@PathVariable("id") String id, @ModelAttribute("libro") libro libroUpdate) {
	    
	//     return "formularioEditarLibro";  
	// }

	@PostMapping("/editarLibro/{id}")
	public String actualizarLibro(@PathVariable("id") String id, @ModelAttribute("libro") Libro libroUpdate) {
	    return "redirect:/listaLibros";  
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		libroService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody Libro libroUpdate){
		var libro= libroService.findOne(id).get();
		if (libro != null) {
			libro.setTitulo(libroUpdate.getTitulo());
			libro.setAutor(libroUpdate.getAutor());
			libro.setISBN(libroUpdate.getISBN());
			libro.setNumero_de_ejemplares_disponibles(libroUpdate.getNumero_de_ejemplares_disponibles());
			libro.setNumero_de_ejemplares_ocupados(libroUpdate.getNumero_de_ejemplares_ocupados());
			libro.setGenero(libroUpdate.getGenero());
			
			
			libroService.save(libro);
			return new ResponseEntity<>("Guardado",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error libro no encontrado",HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
