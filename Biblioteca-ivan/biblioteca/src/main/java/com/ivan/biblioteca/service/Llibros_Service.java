package com.ivan.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.biblioteca.interfaces.interfaz_Libro;
import com.ivan.biblioteca.interfacesService.Interfaz_LibroService;
import com.ivan.biblioteca.models.Libro;



@Service
public class Llibros_Service implements Interfaz_LibroService {
    

    @Autowired
    private interfaz_Libro data;


    @Override
    public String save(Libro libro) {
        data.save(libro);
        return libro.getId();
    }

    @Override
    public List<Libro> findAll() {
        List<Libro> listaLibro = (List<Libro>) data.findAll();
        
        return listaLibro;
    }



    @Override
    public Optional<Libro> findOne(String id) {
        Optional<Libro> libro = data.findById(id);
        
        return libro;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
        return 1;
    }


}
