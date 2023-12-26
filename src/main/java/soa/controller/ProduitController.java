package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import soa.entities.Produit;
import soa.repository.ProduitRepository;

import java.util.List;
import java.util.Optional;
@Service

@RestController
@CrossOrigin
@RequestMapping("/produits")

public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Produit> getAllproduits() {
        return produitRepository.findAll();
    }


    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Produit> getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id);
    }


}