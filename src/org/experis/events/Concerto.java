package org.experis.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int nPostiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, nPostiTotali); //chiama il costruttore della superclasse
        this.ora = LocalTime.now();
        this.prezzo = prezzo;
    }


    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    //metodo per l'ora formattata
    public String getOraFormattata(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(dateFormatter) + " alle " + ora.format(timeFormatter);
    }


    //metodo per il prezzo formattato
    public String getPrezzoFormattato(){
        return prezzo.setScale(2, BigDecimal.ROUND_UP) + "€.";
    }

    @Override
    public String toString(){
        return "\nL'evento"  +" '" + getTitolo() + "' " + "si terrà il " + getOraFormattata()
                + ". Il biglietto ha un costo di " + getPrezzoFormattato() + "\n" + getInfoEvento();
    }

}
