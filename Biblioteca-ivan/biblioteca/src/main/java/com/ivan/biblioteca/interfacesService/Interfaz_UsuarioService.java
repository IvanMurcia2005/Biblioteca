package com.ivan.biblioteca.interfacesService;

import java.util.List;
import java.util.Optional;

import com.ivan.biblioteca.models.Usuarios;




public interface Interfaz_UsuarioService {
    
    public String save(Usuarios usuario);    
    public List<Usuarios> findAll();
    //public List<usuarioo> filtrousuarioo (String filtro);
    public Optional<Usuarios> findOne(String id);
    public int delete(String id);

}
