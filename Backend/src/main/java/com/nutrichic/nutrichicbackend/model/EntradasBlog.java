package com.nutrichic.nutrichicbackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "entradas_blog")
public class EntradasBlog {

    @Id
    @Column(name = "id_entrada")
    private Integer idEntrada;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private CategoriasBlog categoria;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public CategoriasBlog getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasBlog categoria) {
        this.categoria = categoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}