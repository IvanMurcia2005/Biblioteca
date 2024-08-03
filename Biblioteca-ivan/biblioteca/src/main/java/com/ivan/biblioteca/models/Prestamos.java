package com.ivan.biblioteca.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Prestamos {

    @Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id", nullable=false, length = 36)
	private String id;
	
	@Column(name="fechadelPrestamo", nullable=false)
	private String fechadelPrestamo;
	
	@Column(name="fechaDevolucion", nullable=false) 
	private String fechaDevolucion;
	
	@ManyToOne
    @JoinColumn(name = "prestamo_usuario")
    private Usuarios Usuarios;

	@ManyToOne
    @JoinColumn(name = "libroPrestado")
    private Libro Libro;

    @Column(name="Estado", nullable=false)
	private String Estado;
	
    public Prestamos() {
        super();
    }

    public Prestamos(String id, String fechadelPrestamo, String fechaDevolucion,
            com.ivan.biblioteca.models.Usuarios usuarios, com.ivan.biblioteca.models.Libro libro, String estado) {
        this.id = id;
        this.fechadelPrestamo = fechadelPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        Usuarios = usuarios;
        Libro = libro;
        Estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechadelPrestamo() {
        return fechadelPrestamo;
    }

    public void setFechadelPrestamo(String fechadelPrestamo) {
        this.fechadelPrestamo = fechadelPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuarios getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        Usuarios = usuarios;
    }

    public Libro getLibro() {
        return Libro;
    }

    public void setLibro(Libro libro) {
        Libro = libro;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    
  
    

}
