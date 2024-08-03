package com.ivan.biblioteca.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuarios {
    
    @Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id", nullable=false, length = 36)
	private String id;
	
	
	@Column(name="Nombre", nullable=false)
	private String Nombre;
	
	
	@Column(name="Direccion", nullable=false)
	private String Direccion;
	
	
	@Column(name="correoElectronico", nullable=false, length = 320)
	private String correoElectronico;
	
	
	@Column(name="tipo_de_usuario", nullable=false, length = 13)
	private String tipo_de_usuario;


    public Usuarios() {
        super();
    }


    public Usuarios(String id, String nombre, String direccion, String correoElectronico, String tipo_de_usuario) {
        this.id = id;
        Nombre = nombre;
        Direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.tipo_de_usuario = tipo_de_usuario;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getDireccion() {
        return Direccion;
    }


    public void setDireccion(String direccion) {
        Direccion = direccion;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }


    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    public String getTipo_de_usuario() {
        return tipo_de_usuario;
    }


    public void setTipo_de_usuario(String tipo_de_usuario) {
        this.tipo_de_usuario = tipo_de_usuario;
    }
    
}
