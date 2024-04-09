package org.experis.events.bonus;

import org.experis.events.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    // Aggiunge un evento alla lista
    public void aggiungiEvento(Evento evento) {
        this.eventi.add(evento);
    }

    // Restituisce una lista di eventi che si svolgono in una certa data
    public List<Evento> eventiInData(LocalDate data) {
        return this.eventi.stream()
                .filter(evento -> evento.getData().equals(data))
                .collect(Collectors.toList());
    }

    // Restituisce il numero di eventi nel programma
    public int contaEventi() {
        return this.eventi.size();
    }

    // Svuota la lista di eventi
    public void svuotaEventi() {
        this.eventi.clear();
    }

    // Restituisce una stringa con tutti gli eventi ordinati per data
    @Override
    public String toString() {
        return titolo + "\n" + eventi.stream()
                .sorted(Comparator.comparing(Evento::getData))
                .map(evento -> evento.getData().toString() + " - " + evento.getTitolo())
                .collect(Collectors.joining("\n"));
    }
}
