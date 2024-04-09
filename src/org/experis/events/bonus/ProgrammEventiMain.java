package org.experis.events.bonus;

import org.experis.events.Evento;
import org.experis.events.bonus.ProgrammEventi;

import java.time.LocalDate;

public class ProgrammEventiMain {
    public static void main(String[] args) {

        // Creazione di un oggetto ProgrammaEventi
        ProgrammEventi programma = new ProgrammEventi("Festival della Musica");

        // Aggiungiamo eventi al programma
        programma.aggiungiEvento(new Evento("Concerto Rock", LocalDate.of(2024,
                4, 20), 100));
        programma.aggiungiEvento(new Evento("Serata Jazz", LocalDate.of(2024, 4,
                25), 80));
        programma.aggiungiEvento(new Evento("Festival del Blues", LocalDate.of(2024, 4,
                20), 120));

        // Stampa il numero di eventi nel programma
        System.out.println("Numero di eventi nel programma: " + programma.contaEventi());

        // Stampa gli eventi in una certa data
        System.out.println("\nEventi in data 2024-04-20:");
        programma.eventiInData(LocalDate.of(2024, 4, 20)).forEach(evento ->
                System.out.println(evento.getTitolo()));

        // Stampa tutti gli eventi nel programma, ordinati per data
        System.out.println("\nProgramma Eventi:");
        System.out.println(programma);

        // Svuotare la lista di eventi e verificare
        programma.svuotaEventi();
        System.out.println("\nDopo aver svuotato gli eventi, numero di eventi nel programma: "
                + programma.contaEventi());
    }
}
