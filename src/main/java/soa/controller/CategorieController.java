package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import soa.entities.Categorie;
import soa.repository.CategorieRepository;

import java.util.List;
import java.util.Optional;
@Service
@RestController
@CrossOrigin
@RequestMapping("/categories")

public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Categorie> getAllcategories() {
        return categorieRepository.findAll();
    }


    @GetMapping(value = "/{id}" ,  produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Categorie> getcategorieById(@PathVariable Long id) {
        return categorieRepository.findById(id);
    }
}
