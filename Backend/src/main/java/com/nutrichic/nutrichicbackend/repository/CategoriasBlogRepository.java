package com.nutrichic.nutrichicbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutrichic.nutrichicbackend.model.CategoriasBlog;

public interface CategoriasBlogRepository extends JpaRepository<CategoriasBlog, Integer> {

    public CategoriasBlog findByCategoria(String categoria);
}
