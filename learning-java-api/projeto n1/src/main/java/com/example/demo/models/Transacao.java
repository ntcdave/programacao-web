package com.example.demo.models;
import jakarta.persistence.*;


import java.time.OffsetDateTime;

@Entity
@Table(name = "Transactions")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double valor;
    private OffsetDateTime dataHora;

// ----------- getters and setters of Transacao
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
