package com.ivan.biblioteca.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ivan.biblioteca.models.Multa;




@Repository
public interface Interfaz_Multa extends CrudRepository<Multa,String>{
    
}
