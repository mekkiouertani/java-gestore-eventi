package org.experis.events;

import java.time.LocalDate;
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

        System.out.println(evento.toString()); //stampa del titolo e della data formattata


        //chiedere all'utente quanti posti vuole prenotare
        System.out.println("\nInserisci il numero di posti da prenotare: ");
        int postiDaPrenotare = Integer.parseInt(scan.nextLine());
        try{
            evento.prenota(postiDaPrenotare);
            System.out.println("Hai prenotato " + evento.getNPostiPrenotati() + " posti!"); //stampa dei posti prenotati
        }catch (IllegalArgumentException e){
            System.out.println("Errore nella prenotazione. Riprova!");
        }

        System.out.println("posti prenotati: " + evento.getNPostiPrenotati()); //TEST POSTI PRENOTATI

        //chiedere all'utente quanti posti vuole disdire
        System.out.println("\nInserisci il numero di prenotazioni da disdire: ");
        int postiDaDisdire = Integer.parseInt(scan.nextLine());
        try{
            evento.disdici(postiDaDisdire);
            System.out.println("Hai disdetto " + postiDaDisdire + " prenotazioni.");
        }catch(IllegalArgumentException e){
            System.out.println("Errore nella disdetta. Riprova!");
        }

        System.out.println("posti prenotati: " + evento.getNPostiPrenotati()); //TEST POSTI PRENOTATI

        scan.close();
    }
}
