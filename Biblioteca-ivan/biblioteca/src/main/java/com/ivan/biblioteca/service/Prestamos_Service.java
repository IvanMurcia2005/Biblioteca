package com.ivan.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.biblioteca.interfaces.Interfaz_prestamos;
import com.ivan.biblioteca.interfacesService.Interfaz_prestamoService;
import com.ivan.biblioteca.models.Prestamos;




@Service
public class Prestamos_Service  implements Interfaz_prestamoService{

     @Autowired
    private Interfaz_prestamos data;


    @Override
    public String save(Prestamos prestamo) {
        data.save(prestamo);
        return prestamo.getId();
    }

    @Override
    public List<Prestamos> findAll() {
        List<Prestamos> listaPrestamo = (List<Prestamos>) data.findAll();
        
        return listaPrestamo;
    }

    @Override
    public Optional<Prestamos> findOne(String id) {
        Optional<Prestamos> prestamo = data.findById(id);
        
        return prestamo;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
        return 1;
    }
    
}
