package org.experis.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        //chiediamo i dati all'utente
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo = scan.nextLine();

        //TODO: aggiungere eccezione
        System.out.println("Inserisci la data dell'evento (YYYY-MM-DD) : ");
        LocalDate data = LocalDate.parse(scan.nextLine());

        System.out.println("Inserisci il numero di posti disponibile: ");
        int postiTotali = Integer.parseInt(scan.nextLine());


        //passiamo al costruttore i dati che ci fornito l'utente
        //TODO: aggiungere eccezione
        Evento evento = new Evento(titolo, data, postiTotali);

        System.out.println("Operazione riuscita!" + evento.toString()); //stampa del titolo e della data formattata


        boolean exit = false;
        while(!exit) {
            System.out.println("\nVuoi prenotare o disdire dei posti?"
                    + "\n1. Prenota"
                    + "\n2. Disdici"
                    + "\n3. Ottieni info sull'evento corrente"
                    + "\n4. Aggiungi un altro evento"
                    + "\n4. Esci"
            );
            int scelta = Integer.parseInt(scan.nextLine());
            switch (scelta) {
                case 1:   //chiedere all'utente quanti posti vuole prenotare
                    System.out.println("\nInserisci il numero di posti da prenotare: ");
                    int postiDaPrenotare = Integer.parseInt(scan.nextLine());
                    try {
                        evento.prenota(postiDaPrenotare);
                        //stampa dei posti prenotati
                        System.out.println("Hai prenotato " + evento.getNPostiPrenotati() + " posti!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella prenotazione. Riprova!");
                    }
                    break;
                case 2:  //chiedere all'utente quanti posti vuole disdire
                    System.out.println("\nInserisci il numero di prenotazioni da disdire: ");
                    int postiDaDisdire = Integer.parseInt(scan.nextLine());
                    try {
                        evento.disdici(postiDaDisdire);
                        System.out.println("Hai disdetto " + postiDaDisdire + " prenotazioni.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella disdetta. Riprova!");
                    }
                    break;
                case 3:
                    System.out.println( evento.toString()  +evento.getInfoEvento());
                    break;
                case 4:
                    evento = creaEvento(scan); // Sovrascrivi l'evento esistente con un nuovo evento
                    System.out.println("Nuovo evento creato con successo!");
                    break;
                case 5:
                    System.out.println("Operazioni terminate. Arrivederci");
                    exit = true;
                    break;
                default:
                    System.out.println("Operazione non valida, riprova!");
            }
        }
        scan.close();
    }

    //metodo per permettere all'utente di continuare a creare eventi
    private static Evento creaEvento(Scanner scan) {
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo = scan.nextLine();

        System.out.println("Inserisci la data dell'evento (YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(scan.nextLine());

        System.out.println("Inserisci il numero di posti disponibile: ");
        int postiTotali = Integer.parseInt(scan.nextLine());

        // TODO: Gestione delle eccezioni per la creazione dell'evento
        return new Evento(titolo, data, postiTotali);
    }
}
