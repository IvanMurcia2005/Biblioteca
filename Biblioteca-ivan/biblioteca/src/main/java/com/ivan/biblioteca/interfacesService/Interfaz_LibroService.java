package com.ivan.biblioteca.interfacesService;

import java.util.List;
import java.util.Optional;

import com.ivan.biblioteca.models.Libro;



public interface Interfaz_LibroService {

    public String save(Libro libro);    
    public List<Libro> findAll();
    public Optional<Libro> findOne(String id);
    public int delete(String id);
    
}
