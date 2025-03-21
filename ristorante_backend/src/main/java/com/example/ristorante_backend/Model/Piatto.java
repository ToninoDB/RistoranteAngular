package com.example.ristorante_backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "piatti")
public class Piatto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double prezzo;
    private String categoria;
    private String descrizione;

    public Piatto() {}
    public Piatto(String nome, double prezzo, String categoria, String descrizione) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.descrizione = descrizione;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
