package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>  {



}
