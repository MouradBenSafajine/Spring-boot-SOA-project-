package soa.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFacture;
    private BigDecimal montant; // Nom de variable corrigé
    private Date dateFacturation;

    @ManyToOne
    @JoinColumn(name="id_produit")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Facture() {
        // Constructeur par défaut requis pour JPA
    }

    public Facture(String numeroFacture, BigDecimal montant, Date dateFacturation, Client client, Produit produit) {
        this.numeroFacture = numeroFacture;
        this.montant = montant;
        this.dateFacturation = dateFacturation;
        this.client = client;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public boolean isDateFacturationAfterToday() {
        if (dateFacturation != null) {
            Date today = new Date(); // Date actuelle
            return dateFacturation.after(today);
        }
        return false; // ou une autre logique en fonction de vos besoins
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", numeroFacture='" + numeroFacture + '\'' +
                ", montant=" + montant +
                ", dateFacturation=" + dateFacturation +
                ", client=" + client +
                ", produit=" + produit +
                '}';
    }
}
