package org.experis.events;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int nPostiTotali;
    private int nPostiPrenotati;


    public Evento(String titolo, LocalDate data, int nPostiTotali) {
        this.titolo = titolo;
        this.data = data;
        this.nPostiTotali = nPostiTotali;
        this.nPostiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getnPostiTotali() {
        return nPostiTotali;
    }

    public int getNPostiPrenotati() {
        return nPostiPrenotati;
    }


  public void prenota(int nPosti){

  }

  public void disdici (int nPosti){

  }


    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + data +
                ", nPostiTotali=" + nPostiTotali +
                ", nPostiPrenotati=" + nPostiPrenotati +
                '}';
    }
}
