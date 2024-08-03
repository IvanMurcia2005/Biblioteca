package com.ivan.biblioteca.interfacesService;


import java.util.List;
import java.util.Optional;

import com.ivan.biblioteca.models.Multa;



public interface Interfaz_multaService {
    
       public String save(Multa multas);    
    public List<Multa> findAll();
    //public List<multas> filtromultas (String filtro);
    public Optional<Multa> findOne(String id);
    public int delete(String id);
    
}
