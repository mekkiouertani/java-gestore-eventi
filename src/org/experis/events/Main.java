package org.experis.events;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Evento evento = creaEvento(scan); // Creazione del primo evento tramite la funzione creaEvento

        //CREAZIONE MENU
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
            try{
            switch (scelta) {
                //chiedere all'utente quanti posti vuole prenotare
                case 1:
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
                //chiedere all'utente quanti posti vuole disdire
                case 2:
                    System.out.println("\nInserisci il numero di prenotazioni da disdire: ");
                    int postiDaDisdire = Integer.parseInt(scan.nextLine());
                    try {
                        evento.disdici(postiDaDisdire);
                        System.out.println("Hai disdetto " + postiDaDisdire + " prenotazioni.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella disdetta. Riprova!");
                    }
                    break;
                    //stampe le informazioni dell'evento
                case 3:
                    System.out.println( evento.toString() + evento.getInfoEvento());
                    break;
                    //crea un nuovo evento
                case 4:
                    evento = creaEvento(scan); // Sovrascrivi l'evento esistente con un nuovo evento
                    System.out.println("Nuovo evento creato con successo!");
                    break;
                    //EXIT
                case 5:
                    System.out.println("Operazioni terminate. Arrivederci");
                    exit = true;
                    break;
                default:
                    System.out.println("Operazione non valida, riprova!");
            }
            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Input non valido, riprova");
            }
        }
        scan.close();
    }

    //metodo per permettere all'utente di continuare a creare eventi
    private static Evento creaEvento(Scanner scan) {
        String titolo = "";
        while(titolo.isEmpty()){
            System.out.println("Inserisci il nome dell'evento: ");
            titolo = scan.nextLine().trim();
            if(titolo.isEmpty()){
                System.out.println("Il nome non può essere vuoto");
            }
        }

        //forziamo l'utente nell'inserire la data nel formato richiesto
        LocalDate data = null;
        while(data == null) {
            try{
                System.out.println("Inserisci la data dell'evento (YYYY-MM-DD): ");
                data = LocalDate.parse(scan.nextLine());
            } catch (DateTimeException e){
                System.out.println("\nData non valida, riprova!");
            }
        }

        int postiTotali = -1;
        while (postiTotali <= 0) {
            try {
                System.out.println("Inserisci il numero di posti disponibile: ");
                postiTotali = Integer.parseInt(scan.nextLine());
                if (postiTotali <= 0) {
                    System.out.println("Il numero di posti non può essere negativo o 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Per favore, inserisci un numero valido di posti.");
            }
        }

        return new Evento(titolo, data, postiTotali);
    }
}
