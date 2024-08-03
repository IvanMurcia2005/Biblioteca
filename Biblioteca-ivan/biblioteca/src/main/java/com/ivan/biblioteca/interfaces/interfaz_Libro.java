package com.ivan.biblioteca.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ivan.biblioteca.models.Libro;




@Repository
public interface interfaz_Libro  extends CrudRepository<Libro,String>{
    
}
