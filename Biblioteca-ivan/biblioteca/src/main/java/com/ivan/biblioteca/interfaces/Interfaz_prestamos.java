package com.ivan.biblioteca.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ivan.biblioteca.models.Prestamos;




@Repository
public interface Interfaz_prestamos  extends CrudRepository<Prestamos,String>{
    
}
