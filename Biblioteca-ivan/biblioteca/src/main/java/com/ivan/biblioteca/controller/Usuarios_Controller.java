package com.ivan.biblioteca.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.biblioteca.interfacesService.Interfaz_UsuarioService;
import com.ivan.biblioteca.models.Usuarios;


@RequestMapping("/api/v1/usuarios/")
@RestController
@CrossOrigin
@Service
public class Usuarios_Controller {

    
    	@Autowired
	private Interfaz_UsuarioService usuarioService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(
			@ModelAttribute("usuario")Usuarios usuario
			){
		usuarioService.save(usuario);
		return new ResponseEntity<>(usuario,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var listaUsuario=usuarioService.findAll();
		return new ResponseEntity<>(listaUsuario,HttpStatus.OK);
	}
	
	// @GetMapping("/busquedafiltro/{filtro}")
	// public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
	// 	var listaUsuario = usuarioService.filtrousuario(filtro);
	// 	return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
	// }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable("id") String id){
		var usuario=usuarioService.findOne(id);
		return new ResponseEntity<>(usuario,HttpStatus.OK);
	}
	
	// @GetMapping("/editarUsuario/{id}")
	// public String mostrarFormularioDeEditarUsuario(@PathVariable("id") String id, @ModelAttribute("usuario") Usuarios usuarioUpdate) {
	
	//     return "formularioEditarUsuario"; 
	// }

	@PostMapping("/editarUsuario/{id}")
	public String actualizarusuario(@PathVariable("id") String id, @ModelAttribute("usuario") Usuarios usuarioUpdate) {
	
	    return "redirect:/listaUsuarios";  
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		usuarioService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("usuario") Usuarios usuarioUpdate){
		var usuario= usuarioService.findOne(id).get();
		if (usuario != null) {
			usuario.setNombre(usuarioUpdate.getNombre());
			usuario.setDireccion(usuarioUpdate.getDireccion());
			usuario.setCorreoElectronico(usuarioUpdate.getCorreoElectronico());
			usuario.setTipo_de_usuario(usuarioUpdate.getTipo_de_usuario());
			
			usuarioService.save(usuario);
			return new ResponseEntity<>("Guardado",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error usuario no encontrado",HttpStatus.BAD_REQUEST);
		}
		
	}

    
}
