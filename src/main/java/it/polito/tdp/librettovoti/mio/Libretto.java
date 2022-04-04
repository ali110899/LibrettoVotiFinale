package it.polito.tdp.librettovoti.mio;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;  //cercare di definire variabili usando interfacce
	
	public Libretto() {  //creo libretto vuoto
		this.voti = new ArrayList<Voto>();  //crea un oggetto libretto
		
	}  
	
	public boolean add(Voto v) {  //creo il metodo per aggiungere i voti
		// valore di ritorno true/false per sapere se l'azione è andata a buon fine
		if (!isDuplicato(v) && !isConflitto(v)) {
			this.voti.add(v);  //aggiungo in coda un oggetto
			return true;
		}
		return false;
	}

	public Libretto FiltraPunteggio(int punti) {
		Libretto result = new Libretto();  //creo un altro libretto dove ci metto i voti uguali a "punti"
		
		for(Voto v: this.voti) {
			if(v.getPunteggio()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	
	public Integer PunteggioEsame(String nomecorso) {  //dato un corso vado a stamparmi il punteggio del voto ottenuto
		for(Voto v: this.voti) {
			if(v.getCorso().equals(nomecorso)) {
				return v.getPunteggio();
			}
		}
		//return -1;
		//posso fare anche --> throw new IllegalArgumentException("Corso non trovato") <--
		
		return null; //posso farlo solo se ritorno un Integer
	}
	
	public boolean isDuplicato(Voto v) {  //controlla se dato un voto ne esiste uno uguale (vero/falso)
		for (Voto v1: this.voti) {
			if(v1.getCorso().equals(v.getCorso()) && v1.getPunteggio() == v.getPunteggio())
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto v) {  
		Integer punti = this.PunteggioEsame(v.getCorso());
		if(punti!= null && punti!= v.getPunteggio()) {  //ho un conflitto!!
			return true;
		}
		return false;
	}
	
	public List<Voto> getVoti() {
		return this.voti;
	}
	
	public Libretto votiMigliorati() {
		
		Libretto librettoNuovo = new Libretto(); //creo il mio Libretto "migliorato" (vuoto)
		for(Voto v: this.voti) {  //su ogni copia di Voto guardo se può essere "migliorato"
			int punti = v.getPunteggio();
			
			if(punti>=24) {
				punti +=2;
			} else {
				punti ++;
			}
			
			if(punti>30) {
				punti=30;
			}
			
			// NOOOOO così modifichi il libretto principale, noi dobbiamo cambiare la copia di quel libretto
			// v.setPunteggio(punti);
			// librettoNuovo.add(v);
			
			librettoNuovo.add(new Voto(v.getCorso(), punti));  //dopo i check aggiungo il voto migliorato al libretto
		}
		return librettoNuovo;
	}
	
	public void cancellaVotiMinori (int punti) {
		for(Voto v : this.voti) {
			if(v.getPunteggio()<punti) {
				this.voti.remove(v);
			}
		}
	}
	
	public String toString() {  //chiedo all'oggetto "voto" di stamparsi 
		return this.voti.toString();
	}

}
