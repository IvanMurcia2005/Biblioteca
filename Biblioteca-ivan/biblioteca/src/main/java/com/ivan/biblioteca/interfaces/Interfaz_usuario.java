package com.ivan.biblioteca.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ivan.biblioteca.models.Usuarios;





@Repository
public interface Interfaz_usuario  extends CrudRepository<Usuarios,String>{
    

}
