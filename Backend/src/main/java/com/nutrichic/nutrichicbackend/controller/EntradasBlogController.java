package com.nutrichic.nutrichicbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutrichic.nutrichicbackend.model.EntradasBlog;
import com.nutrichic.nutrichicbackend.repository.EntradasBlogRepository;

@RestController
@RequestMapping("/blog")
public class EntradasBlogController {

    @Autowired
    private EntradasBlogRepository entradasBlogRepository;

    @GetMapping
    public List<EntradasBlog> verEntradas() {
        return entradasBlogRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> crearEntrada(@RequestBody EntradasBlog entrada) {
        if (entrada.getTitulo() == null ||
                entrada.getContenido() == null ||
                entrada.getCategoria() == null) {
            return ResponseEntity.badRequest().body("Faltan campos por llenar");
        } else {
            entrada.setFecha(new java.sql.Date(System.currentTimeMillis()));
            EntradasBlog aux = entradasBlogRepository.findTopByOrderByIdEntradaDesc();
            entrada.setIdEntrada(aux == null ? 1 : aux.getIdEntrada() + 1);
            entradasBlogRepository.save(entrada);
            return ResponseEntity.ok().body("Entrada creada");
        }
    }

    @PatchMapping("/editar/{id}")
    public ResponseEntity<String> editarEntrada(@RequestBody EntradasBlog entrada, @PathVariable Integer id) {
        Optional<EntradasBlog> aux = entradasBlogRepository.findById(id);

        if (aux.isPresent()) {
            EntradasBlog entradaActualizada = aux.get();
            entradaActualizada.setTitulo(entrada.getTitulo());
            entradaActualizada.setContenido(entrada.getContenido());
            entradaActualizada.setCategoria(entrada.getCategoria());
            entradaActualizada.setFecha(new java.sql.Date(System.currentTimeMillis()));
            entradasBlogRepository.save(entradaActualizada);
            return ResponseEntity.ok().body("Entrada editada");

        } else {
            return ResponseEntity.badRequest().body("Entrada no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEntrada(@PathVariable Integer id) {
        Optional<EntradasBlog> aux = entradasBlogRepository.findById(id);

        if (aux.isPresent()) {
            entradasBlogRepository.deleteById(id);
            return ResponseEntity.ok().body("Entrada eliminada");
        } else {
            return ResponseEntity.badRequest().body("Entrada no encontrada");
        }
    }
}
