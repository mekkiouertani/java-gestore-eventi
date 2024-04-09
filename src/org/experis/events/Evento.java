package org.experis.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    //costruttore
    public Evento(String titolo, LocalDate data, int nPostiTotali) {

        //eccezione se la data è una data del passato
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data dell'evento non può essere passata.");
        }

        //eccezione se i PostiTotali sono uguali o inferiori a 0
        if(nPostiTotali <= 0){
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.nPostiTotali = nPostiTotali;
        this.nPostiPrenotati = 0; //PostiPrenotati inizializzati a 0
    }

    //metodi Setter e Getter
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


    //funzioni PRENOTA e DISDICI

    //PRENOTA -> se la data è già passata o non ci sono abbastanza posti disponibili -> ECCEZIONE
    public void prenota(int nPosti){
        if(data.isBefore(LocalDate.now()) || (nPostiTotali - nPostiPrenotati) < nPosti){
            throw new IllegalArgumentException("Non è possibile effettuare la prenotazione");
        }
        nPostiPrenotati += nPosti; // aggiunge N posti prenotati
    }

    //DISDICI -> se la data è già passata o non ci sono abbastanza prenotazioni -> ECCEZIONE
    public void disdici(int nPosti){
        if(data.isBefore(LocalDate.now()) || nPostiPrenotati < nPosti || nPosti <= 0 ){
            throw new IllegalArgumentException("Non è stato possibile disdire la prenotazione");
        }
        nPostiPrenotati -= nPosti; // riduce di N i posti prenotati
    }


    public String getInfoEvento() {
        return
                ", ha un totale di " + nPostiTotali + " totali" +
                ", di cui " + nPostiPrenotati + " posti prenotati" +
                " e dispone di " + (nPostiTotali - nPostiPrenotati) + " posti rimanenti.";
    }

    //Metodo toString per formattare la data
    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\nL'evento"  +" '" + titolo + "' " + "si terrà il " + data.format(dateFormatter);
    }
}
