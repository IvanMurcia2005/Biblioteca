package com.ivan.biblioteca.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;





@Entity
public class Multa {

    @Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id", nullable=false, length = 36)
	private String id;
	
	
	@ManyToOne
    @JoinColumn(name = "usuario_multado")
    private Usuarios usuario;
	
	
    @ManyToOne
    @JoinColumn(name = "prestamo_del_usuario")
    private Prestamos prestamo;
	
	
	@Column(name="valor_de_multa", nullable=false)
	private String valor_de_multa;
	
	
	@Column(name="fecha_de_multa", nullable=false)
	private String fecha_de_multa;
	
	
	@Column(name="estado", nullable=false)
	private String estado; 
    

    public Multa() {
        super();
    }


    public Multa(String id, Usuarios usuario, Prestamos prestamo, String valor_de_multa, String fecha_de_multa,
            String estado) {
        this.id = id;
        this.usuario = usuario;
        this.prestamo = prestamo;
        this.valor_de_multa = valor_de_multa;
        this.fecha_de_multa = fecha_de_multa;
        this.estado = estado;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Usuarios getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }


    public Prestamos getPrestamo() {
        return prestamo;
    }


    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
    }


    public String getValor_de_multa() {
        return valor_de_multa;
    }


    public void setValor_de_multa(String valor_de_multa) {
        this.valor_de_multa = valor_de_multa;
    }


    public String getFecha_de_multa() {
        return fecha_de_multa;
    }


    public void setFecha_de_multa(String fecha_de_multa) {
        this.fecha_de_multa = fecha_de_multa;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    

}
