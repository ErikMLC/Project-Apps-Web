package com.nutrichic.nutrichicbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutrichic.nutrichicbackend.model.EntradasBlog;

public interface EntradasBlogRepository extends JpaRepository<EntradasBlog, Integer> {

    public EntradasBlog findTopByOrderByIdEntradaDesc();
}
