package com.ivan.biblioteca.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.biblioteca.interfaces.Interfaz_usuario;
import com.ivan.biblioteca.interfacesService.Interfaz_UsuarioService;
import com.ivan.biblioteca.models.Usuarios;




@Service
public class Usuarios_Service implements Interfaz_UsuarioService{
    
    @Autowired
    private Interfaz_usuario data;


    @Override
    public String save(Usuarios usuario) {
        data.save(usuario);
        return usuario.getId();
    }

    @Override
    public List<Usuarios> findAll() {
        List<Usuarios> listaUsuario = (List<Usuarios>) data.findAll();
        
        return listaUsuario;
    }

    @Override
    public Optional<Usuarios> findOne(String id) {
        Optional<Usuarios> usuario = data.findById(id);
        
        return usuario;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
        return 1;
    }


}
