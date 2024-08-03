package com.ivan.biblioteca.interfacesService;

import java.util.List;
import java.util.Optional;

import com.ivan.biblioteca.models.Prestamos;



public interface Interfaz_prestamoService {
 
      public String save(Prestamos prestamo);    
    public List<Prestamos> findAll();
    //public List<prestamo> filtroprestamo (String filtro);
    public Optional<Prestamos> findOne(String id);
    public int delete(String id);


}