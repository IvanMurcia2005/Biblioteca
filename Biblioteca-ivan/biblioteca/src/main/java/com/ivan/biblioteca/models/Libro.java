package com.ivan.biblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {
 
    @Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id", nullable=false, length = 36)
	private String id;
	
	@Column(name="titulo", nullable=false)
	private String titulo;
	
	@Column(name="autor", nullable=false)
	private String autor;
	
	@Column(name="ISBN", nullable=false)
	private String ISBN;

	@Column(name="numero_de_ejemplares_disponibles", nullable=false, length = 200)
	private String numero_de_ejemplares_disponibles;
	
	@Column(name="numero_de_ejemplares_ocupados", nullable=false, length = 100)
	private String numero_de_ejemplares_ocupados;

    @Column(name="genero", nullable=false, length = 36)
	private String genero;

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getNumero_de_ejemplares_disponibles() {
        return numero_de_ejemplares_disponibles;
    }

    public String getNumero_de_ejemplares_ocupados() {
        return numero_de_ejemplares_ocupados;
    }

    public String getGenero() {
        return genero;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public void setNumero_de_ejemplares_disponibles(String numero_de_ejemplares_disponibles) {
        this.numero_de_ejemplares_disponibles = numero_de_ejemplares_disponibles;
    }

    public void setNumero_de_ejemplares_ocupados(String numero_de_ejemplares_ocupados) {
        this.numero_de_ejemplares_ocupados = numero_de_ejemplares_ocupados;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Libro() {
    }

    public Libro(String id, String titulo, String autor, String iSBN, String numero_de_ejemplares_disponibles,
            String numero_de_ejemplares_ocupados, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        ISBN = iSBN;
        this.numero_de_ejemplares_disponibles = numero_de_ejemplares_disponibles;
        this.numero_de_ejemplares_ocupados = numero_de_ejemplares_ocupados;
        this.genero = genero;
    }

    
	
}