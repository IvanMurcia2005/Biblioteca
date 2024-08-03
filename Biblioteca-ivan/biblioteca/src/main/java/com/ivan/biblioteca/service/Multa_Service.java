package com.ivan.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.biblioteca.interfaces.Interfaz_Multa;
import com.ivan.biblioteca.interfacesService.Interfaz_multaService;
import com.ivan.biblioteca.models.Multa;



@Service
public class Multa_Service implements Interfaz_multaService{

    @Autowired
    private Interfaz_Multa data;


    @Override
    public String save(Multa multas) {
        data.save(multas);
        return multas.getId();
    }

    @Override
    public List<Multa> findAll() {
        List<Multa> listaMultas = (List<Multa>) data.findAll();
        
        return listaMultas;
    }



    @Override
    public Optional<Multa> findOne(String id) {
        Optional<Multa> multas = data.findById(id);
        
        return multas;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
        return 1;
    }

    
}
